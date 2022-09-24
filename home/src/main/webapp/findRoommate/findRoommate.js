$(function () {

  const userId = 4;  //todo

  let memberIdArray = []
  let htmlArray = []
  console.log('------------------------------ 我是 ' + userId)
  checkOpen()
  loadSelectedList()
  loadAllList()

  $('input[type=radio][name=is-open]').change(function () {
    if (this.value === 'open') {
      $('#not-open').hide()
      $('.select-block').show()
      $('.all-find-list').show()
      $('#refresh-btn').removeClass('d-none')
      changeOpenStage(true)
      alert('若未填寫個人描述，請至會員資料填齊。以供其他同學能夠找的到你~')
    } else {
      $('#not-open').show()
      $('.select-block').hide()
      $('.all-find-list').hide()
      $('#refresh-btn').addClass('d-none')
      changeOpenStage(false)
    }
  })

  $('body').on('click', '.make-friend', function (e) {
    const targetId = e.target.getAttribute('data-memberId')
    $.ajax({
      type: 'POST',
      url: '/home/ChatroomServlet?callFrom=createChatroom',
      data: {'Id': userId, 'chatTarget': targetId, 'chatType': 'F'},
      success: function (resp) {
        console.log(resp)
      }
    })
  });

  $('.pick-condition').change(function () {
    renderCorrespondList()
  })

  $('#refresh-btn').click(function () {
    randomList()
    renderCorrespondList()
  })

  function checkOpen() {
    $.ajax({
      type: 'POST',
      url: 'FindFriendServlet?callFrom=checkOpen',
      data: {'userId': userId},
      success: function (resp) {
        if (resp === "true") {
          $('#not-open').hide()
          $('.select-block').show()
          $('.all-find-list').show()
          $('#refresh-btn').removeClass('d-none')

          $('input[type=radio][name=is-open]')
        } else {
          $('#not-open').show()
          $('.select-block').hide()
          $('.all-find-list').hide()
          $('#refresh-btn').addClass('d-none')
        }
      },
      err: function () {
        console.log('wrong!!!')
      }
    })
  }

  function loadAllList() {
    $.ajax({
      type: 'POST',
      url: '/home/FindFriendServlet?callFrom=loadAllList',
      data: {'userId': userId},
      success: function (resp) {
        for (let i = 0; i < resp.length; i++) {
          renderInfo(resp[i])
        }
        randomList()
        return memberIdArray
      }
    })
  }

  function loadSelectedList() {
    $.ajax({
      type: 'POST',
      url: '/home/FindFriendServlet?callFrom=loadSelectedList',
      success: function (resp) {
        for (let i = 0; i < resp.signature.length; i++) {
          $('#character-option1').append(
            `<option>${resp.signature[i]}</option>`)
          $('#character-option2').append(
            `<option>${resp.signature[i]}</option>`)
          $('#character-option3').append(
            `<option>${resp.signature[i]}</option>`)
        }
        for (let i = 0; i < resp.favor.length; i++) {
          $('#favor-option1').append(`<option>${resp.favor[i]}</option>`)
          $('#favor-option2').append(`<option>${resp.favor[i]}</option>`)
          $('#favor-option3').append(`<option>${resp.favor[i]}</option>`)
        }
      }
    })
  }

  function changeOpenStage(stage) {
    $.ajax({
      type: 'POST',
      url: '/home/FindFriendServlet?callFrom=changeStage',
      data: {'userId': userId, 'stage': stage}
    })
  }

  function renderInfo(memberInfo) {
    memberIdArray.push(memberInfo.id)

    const all = document.getElementById('all-find-list')
    const divideBlock = createTag('div', {
      class: 'col-md-6 col-lg-4 mb-4 mb-lg-3 p-2 divide-block',
    });
    const infoBlock = createTag('div', {
      'data-memberId': memberInfo.id,
      'data-selected': 'ture'
    });
    const personBlock = createTag(
      'div',
      {
        class: "h-entry border border-danger pt-4 text-center person-block",
      });

    const imgBlock = createTag('img',
      {
        src: '/home/images/avatarImg/' + memberInfo.avatar,
        class: 'img-fluid avatar'
      })

    const info = createTag('h2', {class: 'font-size-regular'})
    const nameSchoolBlock = createTag('div',
      {class: 'text-dark', 'data-memberId': memberInfo.id})
    const name = createTag('span',
      {class: 'target-name'})
    name.innerText = memberInfo.name

    pAppendC(nameSchoolBlock, name)

    if (memberInfo.school !== "") {
      const school = createTag('span',
        {
          class: 'target-school',
        })
      school.innerText = '(' + memberInfo.school + ')'
      pAppendC(nameSchoolBlock, school)
    }

    pAppendC(info, nameSchoolBlock)

    const charaterFavorBlock = createTag('div', {
      class: 'meta mb-4 mt-2 container-fluid row align-self-center'
    })

    const signatureBlcok = createTag('div',
      {class: 'col-6 text-center signature-block'})
    const signatureTitle = createTag('div', {
      class: 'text-center fs-5 signature-title',
    })
    signatureTitle.innerText = '個性標籤'

    pAppendC(signatureBlcok, signatureTitle)

    for (let i = 0; i < memberInfo.signatures.length; i++) {
      const signature = createTag('div',
        {
          class: 'text-center signature-attr condition-attr',
        })
      signature.innerText = memberInfo.signatures[i]
      pAppendC(signatureBlcok, signature)
    }

    const favorBlcok = createTag('div',
      {class: 'col-6 text-center favor-block'})
    const favorTitle = createTag('div', {
      class: 'text-center fs-5 favor-title',
    })
    favorTitle.innerText = '室友條件'

    pAppendC(favorBlcok, favorTitle)

    for (let i = 0; i < memberInfo.favors.length; i++) {
      const favor = createTag('div',
        {
          class: 'text-center favor-attr condition-attr',
        })
      favor.innerText = memberInfo.favors[i]

      pAppendC(favorBlcok, favor)
    }

    pAppendC(charaterFavorBlock, signatureBlcok)
    pAppendC(charaterFavorBlock, favorBlcok)

    const btnlink = createTag('a', {
      href: '/home/chatRoom.jsp',
    })

    const btnChat = createTag('div', {
      class: 'btn btn-primary px-2 py-2 mx-3 mb-5 chat make-friend',
      id: 'make-friend',
      'data-memberId': memberInfo.id
    })
    btnChat.innerText = '就決定是你了'

    pAppendC(personBlock, imgBlock)
    pAppendC(personBlock, info)
    pAppendC(personBlock, charaterFavorBlock)
    // pAppendC(personBlock, btnChat)
    pAppendC(personBlock, pAppendC(btnlink, btnChat))

    pAppendC(all, pAppendC(divideBlock, pAppendC(infoBlock, personBlock)))

    htmlArray.push(divideBlock.innerHTML)
    return memberIdArray
  }

  function createTag(tagName, props) {
    const tag = document.createElement(tagName)
    Object.entries(props).forEach(([key, value]) => {
      tag.setAttribute(key, value)
    })
    return tag
  }

  function pAppendC(p, c) {
    if (c) {
      p.appendChild(c);
    }
    return p;
  }

  function randomList() {
    for (let i = htmlArray.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [htmlArray[i], htmlArray[j]] = [htmlArray[j], htmlArray[i]];
    }
    const divideList = document.querySelectorAll('.divide-block')
    divideList.forEach((e, i) => {
      e.innerHTML = htmlArray[i]
      i++
    })
  }

  function renderCorrespondList() {

    let selectedConditionArray = []
    $('.pick-condition').each(function () {
      if ($(this).val() !== "0") {
        selectedConditionArray.push($(this).val())
      }
    })

    for (let i = 0; i < memberIdArray.length; i++) {
      const personalConditionArray = []
      $(`*[data-memberid="${memberIdArray[i]}"]`).find(
        $('.condition-attr')).each(function () {
        personalConditionArray.push($(this).text())
      })
      isContain()

      function isContain() {
        for (let j = 0; j < selectedConditionArray.length; j++) {
          if (personalConditionArray.indexOf(selectedConditionArray[j])
            === -1) {
            $(`*[data-memberid="${memberIdArray[i]}"]`).parent().hide()
            return false
          }
        }
        $(`*[data-memberid="${memberIdArray[i]}"]`).parent().show()
        return true
      }
    }
  }

})
