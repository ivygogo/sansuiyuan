$(function () {

  let name1  //  要發訊息的人    //TODO (從會員資料)
  let name2

  $.ajax({
    url: '/home/ChatroomServlet?callFrom=getSessionId',
    type: 'POST',
    async: false,
    success: function (resp) {
      name1 = resp
    }
  })
  console.log('user ==' + name1)
  // 讀取chatroomList  -----------------
  loadExistChatroom(name1)
  // decideBlockSize()
  $("#input-message").prop('disabled', true)

  $('input[name=is-talk-able]').change(function () {
    if ($('input[name=is-talk-able]:checked').val() === "true") {
      $('*[data-open="true"]').show()
      $('*[data-open="false"]').hide()
    } else {
      $('*[data-open="true"]').hide()
      $('*[data-open="false"]').show()
    }
  })

  //--------------------------------------------------
  //finish: WebSocket連線 / 未讀歸零 / 讀取未讀訊息量
  //TODO render新訊息在底下的trimText內

  $('#checklist').on('click', '.chatroom-block', e => {

    name2 = $(e.target).closest('table').find('.chat-target').data('memberid')
    console.log(name2)

    $('#chat-avatar').removeClass('invisible')
    $('#chat-avatar').attr('src',
      `/home/images/avatarImg/${$(e.target).closest('table').data(
        'avatarpic')}`)
    $('#character').text(" ")

    console.log(name2)

    if (name2 !== 0) {
      $('#chat-target').data('memberId', name2)
      $('#chat-target').text(
        `${$(e.target).closest('table').data('targetnickname')}`)
      $('#id-type').text(
        `身分 ： ${$(e.target).closest('table').data('identity')}`)
      if ($(e.target).closest('table').data('moreinfo') !== 'null') {
        $('#character').text(
          `個性標籤：${$(e.target).closest('table').data('moreinfo')}`)
      } else {
        $('#character').text('')
      }
    } else {
      $('#chat-target').data('memberId', 0)
      $('#chat-target').text("房東")
      $('#id-type').text('管理員')
      $('#character').text('')
    }

    if ($(e.target).closest('table').data("open") === true) {
      const chatroomId = $(e.target).closest('table').data("chatroomid")
      $('.isClose-block').html(
        '<div>關閉時間</div><span id="close-time" ></span><div id="for-btn"></div>')

      if (name2 != 0) {
        $('#for-btn').append(
          `<button class="btn btn-primary" id="close-btn" data-roomId =${chatroomId} >婉拒</button >`
        )
      }

      $('#close-time').text(
        $(e.target).closest('table').data("closetime").split(',', 1))
      $("#input-message").prop('disabled', false).prop('placeholder', '請輸入文字')
      $(".btn-send-message").prop('disabled', false)

    } else {
      $('.isClose-block').html('已關閉')
      $("#input-message").prop('disabled', true).prop('placeholder', '')
      $(".btn-send-message").prop('disabled', true)
    }

    $('.chat-inside-block').text("")
    // ------------------
    loadOldChatMessage()

    const chatType = $(e.target).closest('table').data('chattype')
    changeUnreadCount(name1, name2, chatType)
    // ------------------

    ws = new WebSocket(
      `ws://localhost:8080/home/chat/${name1}_${name2}/${name1}`);

    //移動卷軸
    $('.chat-inside-block').scrollTop($('.chat-inside-block')[0].scrollHeight)

    ws.onopen = function () {
    }

    ws.onmessage = function (event) {
      const message = JSON.parse(event.data);
      renderMessage(message)
      // decideBlockSize()

      $('.chat-inside-block').scrollTop($('.chat-inside-block')[0].scrollHeight)

      $(e.target).closest('table').find('.chat-trim-text').text(
        $('.message-content').last().text())
    }

    ws.onclose = function (enent) {
      console.log('close reason = ' + enent.code + " ---" + enent.reason)
    }

    ws.onerror = function (e) {
      console.log('Socket has error', e.reason)
      ws.close()
    }

    $(e.target).closest('table').find('.chat-unread').css(
      {'visibility': 'hidden'})
    // decideBlockSize()
  })

  // 送出------------------
  $('.btn-send-message').click(function () {
    if ($(`#input-message`).val().trim() !== "") {
      const date = new Date()    //發訊息的日期
      // 個位數的數值補零
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
    }
  })

  $('#input-message').keypress(function (enter) {
    if (enter.key === "Enter") {
      $('.btn-send-message').click()
    }
  })

  $('body').on('click', '#close-btn', function () {
    // window.confirm("確認是否要關閉此聊天室")
    if (confirm('確認是否要關閉此聊天室') === true) {
      $('#close-time').text("")
      $('.isClose-block').html('已關閉')
      $.ajax(
        {
          type: 'POST',
          url: '/home/ChatroomServlet?callFrom=changeCloseTime',
          data: {'roomId': $(this).data('roomid'), 'additionalTime': 0},
          success: function () {
            location.reload()
          }
        })
      console.log('yes')
    } else {
      console.log('cancel')
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

    } else if (windowInnerWidth >= 710 && windowInnerWidth < 810) {
      const leftWidth = 250
      const rightWidth = windowInnerWidth - leftWidth - 45
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
      // $('.chat-main-block-left').css({display :'none'})
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
      url: '/home/ChatroomServlet?callFrom=loadChatroomList',
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

  // -----------------
  function renderChatroomList(resp) {
    let target
    for (let i = 0; i < resp.length; i++) {
      console.log(resp)
      target = resp[i].target
      if (resp[i].moreInfo === 'X') {
        resp[i].moreInfo = '無'
      }
      $('#checklist').append(
        `<table class="chatroom-block" data-identity=${resp[i].identity}
          data-chatroomId=${resp[i].chatroomId}
          data-moreInfo=${resp[i].moreInfo} data-avatarpic=${resp[i].avatarPic}
          data-targetNickName=${resp[i].targetNickName}
          data-closetime=${resp[i].closeTime} data-open=${resp[i].isOpen}
          data-chattype= ${resp[i].chatroomType} data-targe=${target}}>
          <tr>
            <td rowSpan="2" style="width: 70px">
              <img src="/home/images/avatarImg/${resp[i].avatarPic}" alt="X"
                   class="chat-avatar "></td>
            <td class="chat-target" data-memberid=${target}>${resp[i].targetNickName}</td>
            <td class="chat-unread" data-unRead=${resp[i].unRead}>${resp[i].unRead}</td>
          </tr
          <tr>
            <td colSpan="2">
              <div class="chat-trim-text">${resp[i].content}</div>
            </td>
          </tr>
        </table>`)
      $('.chat-avatar').width('65px ')
    }
    $('[data-unread="0"]').hide()
  }

  // -----------------
  function loadOldChatMessage() {
    $.ajax({
        type: 'POST',
        url: '/home/ChatroomServlet?callFrom=loadOldMessage',
        data: {
          'user': name1, 'target': name2
        },
        success: function (resp) {
          if (name2 !== 0) {
            for (let k = 0; k < resp.length; k++) {
              if (k === 0) {
                $('.chat-inside-block').append(`
                 <div class="send-message-block row m-3 bg-primary system-message">
                   <span class="send-message-content col-12 ">${resp[k].content}</span>
                   <span class="send-message-time col-12 text-end">${resp[k].currentTime}</span>
                 </div>`)
              } else {
                renderMessage(resp[k])
              }
            }
          } else {
            for (let k in resp) {
              renderMessage(resp[k])
            }
          }

          $('.chat-inside-block').scrollTop(
            $('.chat-inside-block')[0].scrollHeight)
        },
        err: function () {
          console.log('renderChatroomList with error')
        }
      }
    )
  }

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

      if (`${message.sender}` === name1) {
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

  function changeUnreadCount(userId, targetId, chatType) {
    $.ajax({
      type: 'POST',
      url: '/home/ChatroomServlet?callFrom=changeReadCount',
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
