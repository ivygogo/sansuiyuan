$(function () {

  $('#room-building').change(function () {
    $('#room-building-value').remove()
    $(document.createElement("div")).text(
      '大樓 : ' + $('#room-building').val()).attr('id',
      'room-building-value').appendTo($('#tenant-information'))
  })

  $('#room-floor').change(function () {
    $('#room-floor-value').remove()
    $(document.createElement("div")).text(
      '樓層 : ' + $('#room-floor').val()).attr('id',
      'room-floor-value').appendTo($('#tenant-information'))
  })

  $('#room-position').change(function () {
    // $.ajax("/wuli/RoomTypeServlet").done()
    $('#room-position-value').remove()
    $(document.createElement("div")).text(
      '位置 : ' + $('#room-position').val()).attr('id',
      'room-floor-value').appendTo($('#tenant-information'))
  })

  $('#room-type').change(function () {
    $('#room-type-value').remove()

    const type = $('#room-type').val()

    if (type === "0") {
      $('#room-type-value').remove()
      $('#room-type-main').addClass('d-none')
      $('#room-price').text("------")
      $('#room-size').text("------")
      $('#room-status').text("------")
      return;
    }

    $(document.createElement("div")).text(
      '房型代號 : ' + type + '  房型名稱 : ' + $(
        '#room-type option:selected').text()).attr('id',
      'room-type-value').appendTo($('#tenant-information'))

    $('#room-type-main').removeClass('d-none')

    $.getJSON('/wuli/common/RoomTypeServlet', type, function (res) {
      const roomType = res[type]

      //清除圖片
      $('#img-slide-block').html("")
      //根據房型新增圖片上去
      const renderImg = roomType => {
        const $imgBlock = $('#img-slide-block')
        let n = 0
        return roomType.pics.forEach(roomTypePic => {
          if (n == 0) {
            const $imgSlide = $(document.createElement("div")).addClass(
              "carousel-item").addClass("active")
            const $storeImg = $(document.createElement("img")).attr("src",
              "./images/roomtype/" + roomTypePic).attr("alt",
              "don't find pic").addClass(
              "container-fluid").addClass("img-height")
            $imgSlide.append($storeImg).appendTo($imgBlock)
            n++
          } else {
              const $imgSlide = $(document.createElement("div")).addClass(
                "carousel-item")
              const $storeImg = $(document.createElement("img")).attr("src",
                "./images/roomtype/" + roomTypePic).attr("alt",
                "don't find pic").addClass(
                "container-fluid").addClass("img-height").addClass("d-block")
              $imgSlide.append($storeImg).appendTo($imgBlock)
              n++
            }
          }
        )
      }
      renderImg(roomType)

      //修正各房型的內容
      $('#room-item-chair').text(roomType.chair)
      $('#room-item-bed').text(roomType.bed)
      $('#room-item-desk').text(roomType.desk)
      $('#room-item-sideTable').text(roomType.sideTable)
      $('#room-item-wardrobe').text(roomType.wardrobe)
      $('#room-price').text(roomType.price)
      $('#room-size').text(roomType.size + '坪')
      $('#room-status').text(roomType.status)

      if (roomType.balcony == true) {
        $('#room-item-balcony').removeClass('d-none')
      } else {
        $('#room-item-balcony').addClass('d-none')
      }
    });
  })
})

