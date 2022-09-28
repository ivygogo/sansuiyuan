$(function () {
  //http://localhost:8080/home/roomtype.jsp?type=C
  const url = location.href
  let beginType
  if (url.indexOf('?') != -1) {
    const ary1 = url.split('?')
    const ary2 = ary1[1].split('&')
    const ary3 = ary2[0].split('=')
    beginType = ary3[1];
  } else {
    beginType = 'A'
  }

  const AVAILABLE_ROOM_TYPES = ['A', 'B', 'C', 'D', 'E', 'F']
  let index = AVAILABLE_ROOM_TYPES.indexOf(beginType)

  function renderFeature() {
    const type = AVAILABLE_ROOM_TYPES[index];

    $.getJSON('/home/common/RoomTypeServlet', type, function (res) {
      const roomType = res;
      $('#room-type-title').text(roomType.name)
      $('#room-type-price').text(roomType.price + ' 元 / 月')
      $('#room-type-rest').text(roomType.rest)
      $('#room-type-size').text(roomType.size)

      if (roomType.rest === 0) {
        $('#creatBooking').addClass('invisible')
      } else {
        $('#creatBooking').removeClass('invisible')
      }

      if (roomType.availableFloors.length !== 0) {
        $('#room-type-available-floor').text(roomType.availableFloors)
      } else {
        $('#room-type-available-floor').text('無')
      }

      if (roomType.balcony === true) {
        $('#room-item-balcony').removeClass('d-none')
      } else {
        $('#room-item-balcony').addClass('d-none')
      }

      const roomItemBed = $('#room-item-bed')
      roomItemBed.html(roomType.bed)
      const roomItemDesk = $('#room-item-desk')
      roomItemDesk.html(roomType.desk)
      const roomItemSideTable = $('#room-item-sideTable')
      roomItemSideTable.html(roomType.sideTable)
      $('#room-item-wardrobe').html(roomType.wardrobe)
      $('#room-item-chair').html(roomType.chair)

      if (roomItemBed.text().includes('雙人床')) {
        roomItemBed.attr('title', '5呎 * 6.2呎')
      } else {
        roomItemBed.attr('title', '3.5呎 * 6.2呎')
      }
      if (roomItemSideTable.text().includes('大')) {
        roomItemSideTable.attr('title', '5呎')
      } else {
        roomItemSideTable.attr('title', '3.5呎')
      }
      if (roomItemDesk.text().includes('大')) {
        roomItemDesk.attr('title', '5呎')
      } else {
        roomItemDesk.attr('title', '3.5呎')
      }

      const renderImg = roomType => {
        const $imgBlock = $('#img-slide-block')
        let picNum = 0
        return roomType.pics.forEach(roomTypePic => {
            if (picNum === 0) {
              const $imgSlide = $(document.createElement('div')).addClass(
                'carousel-item').addClass('active')
              const $storeImg = $(document.createElement('img')).attr('src',
                './images/roomtype/' + roomTypePic).attr('alt',
                "don't find pic").addClass(
                'container-fluid').addClass('img-height')
              $imgSlide.append($storeImg).appendTo($imgBlock)
              picNum++
            } else {
              const $imgSlide = $(document.createElement('div')).addClass(
                'carousel-item')
              const $storeImg = $(document.createElement('img')).attr('src',
                './images/roomtype/' + roomTypePic).attr('alt',
                "we can't find this picture,check location").addClass(
                'container-fluid').addClass('img-height').addClass('d-block');
              $imgSlide.append($storeImg).appendTo($imgBlock)
            }
          }
        )
      }
      renderImg(roomType)
    })
  }

  renderFeature()

  const roomTypesCount = AVAILABLE_ROOM_TYPES.length;
  $('#pre-room-type').click(function () {
    $('#img-slide-block').html("")
    index = (index - 1 + roomTypesCount) % roomTypesCount
    renderFeature()
    $('#formDialogDiv').addClass('d-none')

  })

  $('#next-room-type').click(function () {
    $('#img-slide-block').html("")
    index = (index + 1 + roomTypesCount) % roomTypesCount
    renderFeature()
    // $('#createBooking')[0].click()
    $('#formDialogDiv').addClass('d-none')

  })

  $('#createBooking').click(function () {
    //todo 確認是否有登入
    $('#move-to-bookingJsp')[0].click()

    if ($('#createBooking').text().includes('取消')) {
      $('#createBooking').text('我要預約')
      $('#formDialogDiv').addClass('d-none')
    } else {
      $('#booking-room-type').val($('#room-type-title')[0].textContent)
      $('#createBooking').text('取消')
      $('#formDialogDiv').removeClass('d-none')
    }

  })
})
