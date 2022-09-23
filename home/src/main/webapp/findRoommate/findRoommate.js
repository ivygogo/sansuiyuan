$(function () {

  const userId = 4;  //todo

  let memberIdArray = []
  let selectedConditionArray = []

  console.log('------------------------------ 我是 ' + userId)
  checkOpen()
  loadSelectedList()
  loadAllList()

  $('input[type=radio][name=is-open]').change(function () {
    if (this.value === 'open') {
      $('#not-open').addClass('d-none')
      $('.select-block').removeClass('d-none')
      $('.all-find-list').removeClass('d-none')
      changeOpenStage(true)
      alert('若未填寫個人描述，請至會員資料填齊。以供其他同學能夠找的到你~')
    } else {
      $('#not-open').removeClass('d-none')
      $('.select-block').addClass('d-none')
      $('.all-find-list').addClass('d-none')
      changeOpenStage(false)
    }
  })

  $('.make-friend').click(function (e) {
    const targetId = e.target.getAttribute('data-memberId')
    console.log(targetId)
    $.ajax({
      type: 'POST',
      url: '/home/FindFriendServlet?callFrom=makePair',
      data: {'userId': userId, 'targetId': targetId}
    })
  })

  $('.pick-condition').change(function () {
    selectedConditionArray = []
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

      const isOpen = isContain()

      function isContain() {
        for (let j = 0; j < selectedConditionArray.length; j++) {
          if (personalConditionArray.indexOf(selectedConditionArray[j])
            === -1) {
            $(`*[data-memberid="${memberIdArray[i]}"]`).hide()
            return false
          }
        }
        $(`*[data-memberid="${memberIdArray[i]}"]`).show()
        return true
      }
    }
  })

  function checkOpen() {
    $.ajax({
      type: 'POST',
      url: 'FindFriendServlet?callFrom=checkOpen',
      data: {'userId': userId},
      success: function (resp) {
        if (resp === "true") {
          $('#not-open').addClass('d-none')
          $('.select-block').removeClass('d-none')
          $('.all-find-list').removeClass('d-none')
          $('input[type=radio][name=is-open]')
        } else {
          $('#not-open').removeClass('d-none')
          $('.select-block').addClass('d-none')
          $('.all-find-list').addClass('d-none')
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
        console.log(resp)
        for (let i = 0; i < resp.length; i++) {
          renderAllInfo(resp[i])
        }
        console.log('correspond array = ' + memberIdArray)
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

  function renderAllInfo(memberInfo) {
    memberIdArray.push(memberInfo.id)

    const all = document.getElementById('all-find-list')
    const infoBlock = createTag('div', {
      class: 'col-md-6 col-lg-4 mb-4 mb-lg-3 p-2',
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

    const btnChat = createTag('div', {
      class: 'btn btn-primary px-2 py-2 mx-3 make-friend',
      'data-memberId': memberInfo.id, value: '就決定是你了'
    })
    btnChat.innerText = '就決定是你了'

    pAppendC(personBlock, imgBlock)
    pAppendC(personBlock, info)
    pAppendC(personBlock, charaterFavorBlock)
    pAppendC(personBlock, btnChat)

    pAppendC(all, pAppendC(infoBlock, personBlock))
    return memberIdArray
  }

  function renderConditionalInfo(e) {
    console.log(e.target())

    // if (true){
    //   show()
    // }
    // else{
    //   hide()
    // }

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
})
