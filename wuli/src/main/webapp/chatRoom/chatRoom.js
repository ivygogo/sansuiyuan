//todo  可直接開啟聊天室?? 可強開已關閉的聊天室??  需不需要disable??
$(function () {
  window.onresize = decideBlockSize

  const name1 = 0 //
  let name2 //接收訊息的人targetId
  // finish! 讀取chatroomList  -----------------
  loadExistChatroom(name1)

  $("#input-message").prop('disabled', true)

  //搜尋 todo
  $('.search-icon').click(function () {
    if ($('#search').hasClass('d-none')) {
      $('#search').removeClass('d-none')
      $('#search').keypress(function (enter) {
        if (enter.key === "Enter") {
          if ($('#search').val().trim() !== '') {
            console.log($('#search').val())
          } else {
            console.log('nothing')
          }
        }
      })
    } else {
      $('#search').addClass('d-none')
    }
  })

  // 根據選擇顯示聊天對象 -----------------
  $('.form-select').change(function () {
    showSelect()
  })

  $('input[name=is-talk-able]').change(function () {
    showSelect()
  })

  $(`*[data-memberid="${name2}"]`).closest('table').find(
    '.chat-trim-text').text(
    $('.message-content').last().text())

  function showSelect() {
    const chatroomBlock = $('.chatroom-block')
    const selectValue = $('.form-select').val()
    chatroomBlock.hide()
    if (selectValue === '0') {
      if ($('input[name=is-talk-able]:checked').val() === "true") {
        $('*[data-open="true"]').show()
        $('*[data-open="false"]').hide()
      } else {
        $('*[data-open="true"]').hide()
        $('*[data-open="false"]').show()
      }
    } else {
      $(`*[data-chattype="${selectValue}"]`).show()
      if ($('input[name=is-talk-able]:checked').val() === "true") {
        $('*[data-open="false"]').hide()
      } else if ($('input[name=is-talk-able]:checked').val() === "false") {
        $('*[data-open="true"]').hide()
      }
    }
  }

  // 開啟對話框 ----------------- TODO 如何得到其他聊天室窗的新訊息&未讀增加

  $('#checklist').on('click', '.chatroom-block', e => {

    //  要傳訊息的對象  ------------
    name2 = $(e.target).closest('table').find('.chat-target').data('memberid')

    $('#chat-avatar').removeClass('invisible')

    $('#chat-target').data('memberId', name2)

    $('#chat-avatar').attr('src',
      `/wuli/images/avatarImg/${$(e.target).closest('table').data(
        'avatarpic')}`)
    $('#chat-target').text(
      `${$(e.target).closest('table').data('targetnickname')}`)
    $('#id-type').text(`${$(e.target).closest('table').data('identity')}`)

    $('#character').html("")

    if ($(e.target).closest('table').data('moreinfo') !== 'undefined') {
      $('#character').html(
        `<span>房號：${$(e.target).closest('table').data('moreinfo')}</span>`)
    }

    if ($(e.target).closest('table').data("open") === true) {
      $('.isClose-block').html('關閉時間：<span id="close-time"></span>')
      $('#close-time').text(
        $(e.target).closest('table').data("closetime").split(',', 1))
      $("#input-message").prop('disabled', false).prop('placeholder', '請輸入文字')
      $(".btn-send-message").prop('disabled', false)

    } else {
      $('.isClose-block').html('本聊天室已關閉') //todo 可強制開啟?????????
      $("#input-message").prop('disabled', true).prop('placeholder', '')
      $(".btn-send-message").prop('disabled', true)
    }

    $('.chat-inside-block').text("")
    // ------------------
    loadOldChatMessage()

    const chatType = $(e.target).closest('table').data('chattype')
    changeUnreadCount(name1, name2, chatType)

    // WebSocket連線 ----------------- TODO 如何得到其他聊天室窗的新訊息&未讀增加
    ws = new WebSocket(
      `ws://localhost:8080/home/chat/${name1}_${name2}/${name1}`);

    //移動卷軸 ------------------
    $('.chat-inside-block').scrollTop($('.chat-inside-block')[0].scrollHeight)

    //onMessage ------------------
    ws.onmessage = function (event) {
      const message = JSON.parse(event.data);
      renderMessage(message)
      // decideBlockSize()

      $('.chat-inside-block').scrollTop($('.chat-inside-block')[0].scrollHeight)

      $(e.target).closest('table').find('.chat-trim-text').text(
        $('.message-content').last().text())
    }

    ws.onclose = function (enent) {
      console.log('close reason = ' + enent.code + " --- " + enent.reason)
    }

    // $(e.target).closest('table').find('.chat-unread').text('0')
    $(e.target).closest('table').find('.chat-unread').css(
      {'visibility': 'hidden'})
  })

  // 送出 ------------------
  $('.btn-send-message').click(function () {
    const date = new Date()    //發訊息的日期
    const currentDate = `${date.getMonth() + 1}`.padStart(2, '0') + "/"
      + `${date.getDate()}`.padStart(2, '0')
    const currentTime = `${date.getHours()}`.padStart(2, '0') + ":"
      + `${date.getMinutes()}`.padStart(2, '0')
    // 讀入對話框內文字
    const content = $('#input-message').val()
    const jsonMessage = JSON.stringify({
      'content': content,
      'sender': name1,
      'receiver': name2,
      'currentDate': currentDate,
      'currentTime': currentTime
    })
    ws.send(jsonMessage)
    $('#input-message').val("")
  })

  $('#input-message').keypress(function (enter) {
    if (enter.key === "Enter") {
      $('.btn-send-message').click()
    }
  })

  //決定block大小 ------------------
  function decideBlockSize() {
    const windowInnerWidth = window.innerWidth

    if (windowInnerWidth >= 810) {
      const leftWidth = (windowInnerWidth - 100) / 3
      const rightWidth = windowInnerWidth - leftWidth - 50
      const targetWidth = leftWidth - 140
      const textWidth = leftWidth - 130

      $('.chat-main-block-left').css(
        {display: 'block', width: leftWidth}).removeClass('sideMenu')
      $('.chat-main-block-right').css({width: rightWidth})

      $('.chat-target').css({width: targetWidth})  // 60+50+10
      $('.chat-trim-text').css({width: textWidth})
      $('.chat-unread-count').css({width: 10})

      $('#sideMenu--active').removeClass('sideMenu--active').addClass('d-none')
      $('#side-label').removeClass('side-label').addClass('d-none')
      $('#input-message').css({width: rightWidth * 0.66})
      $('.btn-send-message').css({width: rightWidth * 0.2})

    } else if (windowInnerWidth >= 720 & windowInnerWidth < 810) {
      const leftWidth = 250
      const rightWidth = windowInnerWidth - leftWidth - 100
      const targetWidth = leftWidth - 140
      const textWidth = leftWidth - 130

      $('.chat-main-all').css({'transform': 'translateX(0.5%)'})

      $('.chat-main-block-left').css(
        {display: 'block', width: leftWidth}).removeClass('sideMenu')
      $('.chat-main-block-right').css({width: rightWidth})

      $('.chat-target').css({width: targetWidth})  // 60+50+10
      $('.chat-trim-text').css({width: textWidth})
      $('.chat-unread-count').css({width: 10})

      $('#sideMenu--active').removeClass('sideMenu--active').addClass('d-none')
      $('#side-label').removeClass('side-label').addClass('d-none')

      $('#input-message').css({width: rightWidth * 0.66})
      $('.btn-send-message').css({width: rightWidth * 0.2})
    } else {
      const leftWidth = 250
      const targetWidth = leftWidth - 140
      const textWidth = leftWidth - 130

      $('.chat-main-all').css({'transform': 'translateX(-20%)'})
      $('.chat-main-block-right').css({width: windowInnerWidth - 50})
      $('.chat-main-block-left').css({width: leftWidth}).addClass('sideMenu',
        'd-none')

      $('.chat-target').css({width: targetWidth, 'font-size': 20})  // 60+50+10
      $('.chat-trim-text').css({width: textWidth})
      $('.chat-unread-count').css({width: 10})

      $('#sideMenu--active').addClass('sideMenu--active').removeClass('d-none')
      $('#side-label').addClass('side-label').removeClass('d-none')

      $('#input-message').css({width: (windowInnerWidth - 50) * 0.66})
      $('.btn-send-message').css({width: (windowInnerWidth - 50) * 0.2})
    }
  }

  //用來改變左側bar的箭頭方向 -----------------
  $('.side-label').click(function () {
    if ($('.side-label').hasClass('rotate-arrow')) {
      $('.side-label').removeClass('rotate-arrow')
    } else {
      $('.side-label').addClass('rotate-arrow')
    }
  })

  // -----------------
  function loadExistChatroom(name1) {
    $.ajax({
      type: 'POST',
      url: '/wuli/ChatroomServlet?callFrom=loadChatroomList',
      data: {'Id': name1},
      success: function (resp) {
        renderChatroomList(resp)
        decideBlockSize()

      },
      err: function () {
        console.log('renderChatroomList with error')
      }
    })
  }

  // 從回應去產出聊天列表-----------------
  function renderChatroomList(resp) {
    console.log(resp)
    let target;
    for (let i = 0; i < resp.length; i++) {
      target = resp[i].target
      $('#checklist').append(
        `<table class="chatroom-block" data-identity=${resp[i].identity}
          data-moreInfo=${resp[i].moreInfo} data-avatarpic=${resp[i].avatarPic}
          data-targetNickName=${resp[i].targetNickName}
          data-closetime=${resp[i].closeTime} data-open=${resp[i].isOpen}
          data-chattype= ${resp[i].chatroomType} data-targe=${target}}>
          <tr>
            <td rowSpan="2" style="width: 70px">
              <img src="/wuli/images/avatarImg/${resp[i].avatarPic}" alt="X" width="60px"
                   class="chat-avatar"></td>
            <td class="chat-target" data-memberid=${target}>${resp[i].targetNickName}</td>
            <td class="chat-unread" data-unRead=${resp[i].unRead}>${resp[i].unRead}</td>
          </tr>
          <tr>
            <td colSpan="2">
              <div class="chat-trim-text">${resp[i].content}</div>
            </td>
          </tr>
        </table>`)
    }
    $('*[data-unread="0"]').hide()
  }

  // -----------------
  function loadOldChatMessage() {
    $.ajax({
      type: 'POST',
      url: '/wuli/ChatroomServlet?callFrom=loadOldMessage',
      data: {
        'user': name1, 'target': name2
      },
      success: function (resp) {
        for (let k in resp) {
          renderMessage(resp[k])
        }
        $('.chat-inside-block').scrollTop(
          $('.chat-inside-block')[0].scrollHeight)
      },
      err: function () {
        console.log('renderChatroomList with error')
      }
    })
  }

  // -----------------
  function renderMessage(message) {
    if (message.receiver === $('#chat-target').data('memberId')
      || message.sender === $('#chat-target').data('memberId')) {
      if (message.currentDate !== $('.date-change').last().text()) {
        $('.chat-inside-block').append(`
      <div class="date-divide">
        <span class="date-change">${message.currentDate}</span>
      </div>
      `)
      }
      if (message.sender === name1) {
        $('.chat-inside-block').append(`
       <div class="send-message-block row m-3">
        <span class="col-4"></span>
        <span class="send-message-content col-8 message-content">${message.content}</span>
        <span class="col-4"></span>
        <span class="send-message-time col-8 text-end">${message.currentTime}</span>
       </div>`)
      } else {
        $('.chat-inside-block').append(`
       <div class="send-message-block row m-3">
        <span class="send-message-content col-8 message-content">${message.content}</span>
        <span class="col-4"></span>
        <span class="send-message-time col-8 text-end">${message.currentTime}</span>
        <span class="col-4"></span>
       </div>`)
      }
    }
  }

  // -----------------
  function changeUnreadCount(userId, targetId, chatType) {
    $.ajax({
      type: 'POST',
      url: '/wuli/ChatroomServlet?callFrom=changeReadCount',
      data: {
        'userId': userId,
        'targetId': targetId,
        'chatType': chatType
      },
      err: function () {
        console.log('changeUnreadCount() with error')
      }
    })
  }

})
