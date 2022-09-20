$(function () {

  const userId = 4;

  console.log('+++++++++++++++++++++++++++++++++++' + userId)
  window.onload = checkOpen
  console.log('------------------------------' + userId)

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

  $('.add-to-change').click(function (e) {
    const targetId = e.target.getAttribute('data-memberId')
    console.log(targetId)
    $.ajax({
      type: 'POST',
      url: '/home/FindFriendServlet?callFrom=makePair',
      data: {'userId': userId, 'targetId': targetId}
    })

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

  function changeOpenStage(stage) {
    $.ajax({
      type: 'POST',
      url: '/home/FindFriendServlet?callFrom=changeStage',
      data: {'userId': userId, 'stage': stage}
    })
  }

})
