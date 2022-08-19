$(function () {

  const Type = "A"  //begin type ,會由nav產生
  let asciiType = Type.charCodeAt()   //A ~ F =65 ~70
  function renderFeature(asciiType) {
    const type = String.fromCharCode(asciiType)

    $.getJSON('/home/common/RoomTypeServlet', type, function (res) {
      const roomType = res;

      $('#room-type-title').text(roomType.name)
      $('#room-type-price').text(roomType.price + " 元 / 月")
      $('#room-type-rest').text(roomType.rest)
      $('#room-type-size').text(roomType.size)

      if (roomType.rest == 0) {
        $('#creatBooking').addClass("invisible")
      } else {
        $('#creatBooking').removeClass("invisible")
      }

      if (roomType.availableFloors.length != 0) {
        $('#room-type-available-floor').text(roomType.availableFloors)
      } else {
        $('#room-type-available-floor').text("無")
      }

      if (roomType.balcony == true) {
        $('#room-item-balcony').removeClass('d-none')
      } else {
        $('#room-item-balcony').addClass('d-none')
      }
      $('#room-item-chair').html(roomType.chair)
      $('#room-item-bed').html(roomType.bed)
      $('#room-item-desk').html(roomType.desk)
      $('#room-item-sideTable').html(roomType.sideTable)
      $('#room-item-wardrobe').html(roomType.wardrobe)

      const renderImg = roomType => {
        const $imgBlock = $('#img-slide-block')
        let picNum = 0
        return roomType.pics.forEach(roomTypePic => {
            if (picNum == 0) {
              const $imgSlide = $(document.createElement("div")).addClass(
                "carousel-item").addClass("active")
              const $storeImg = $(document.createElement("img")).attr("src",
                "./images/roomtype/" + roomTypePic).attr("alt",
                "don't find pic").addClass(
                "container-fluid").addClass("img-height")
              $imgSlide.append($storeImg).appendTo($imgBlock)
              picNum++
            } else {
              const $imgSlide = $(document.createElement("div")).addClass(
                "carousel-item")
              const $storeImg = $(document.createElement("img")).attr("src",
                "./images/roomtype/" + roomTypePic).attr("alt",
                "we can't find this picture,check location").addClass(
                "container-fluid").addClass("img-height").addClass("d-block")
              $imgSlide.append($storeImg).appendTo($imgBlock)
            }
          }
        )
      }
      renderImg(roomType)
    })
  }

  renderFeature(asciiType)

  $('#pre-room-type').click(function () {
    $('#img-slide-block').html("")
    asciiType -= 1
    if (asciiType == 64) {
      asciiType += 6
    }
    renderFeature(asciiType)
  })

  $('#next-room-type').click(function () {
    $('#img-slide-block').html("")
    asciiType += 1
    if (asciiType > 70) {
      asciiType -= 6
    }
    renderFeature(asciiType)
  })

  $('#creatBooking').click(function () {
    alert("booking!!!!!")

  })
})

