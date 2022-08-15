$(function () {
  let n = 1
  const roomTypes =
    {
      0: {},
      A: {
        "name": "單人房A",
        "chair": "椅子*1",
        "bed": "雙人床",
        "desk": "大桌子",
        "sideTable": "小床頭櫃",
        "wardrobe": "衣櫃",
        "size": 5,
        "price": 8100,
        "balcony": false,
        "pic": ["SingleA1.jpg", "SingleA2.jpg", "SingleA3.jpg"],
        "rest": 1,
        "availableFloor": [1, 3, 8]
      },
      B: {
        "name": "單人房B",
        "chair": "椅子*1",
        "bed": "雙人床",
        "desk": "大桌子",
        "sideTable": "小床頭櫃",
        "wardrobe": "衣櫃",
        "size": 5.2,
        "price": 8200,
        "balcony": true,
        "pic": ["SingleB1.jpg", "SingleB2.jpg", "SingleB3.jpg"],
        "rest": 2,
        "availableFloor": [1, 5, 8]
      },
      C: {
        "name": "單人房C",
        "chair": "椅子*2",
        "bed": "單人床",
        "desk": "大桌子",
        "sideTable": "小床頭櫃",
        "wardrobe": "大衣櫃",
        "size": 5.3,
        "price": 8300,
        "balcony": true,
        "pic": ["SingleC1.jpg", "SingleC2.jpg", "SingleC3.jpg"],
        "rest": 3,
        "availableFloor": [1, 2]
      },
      D: {
        "name": "雙人房A",
        "chair": "椅子*2",
        "bed": "單人床",
        "desk": "大桌子",
        "sideTable": "小床頭櫃",
        "wardrobe": "衣櫃",
        "size": 6.1,
        "price": 8400,
        "balcony": false,
        "pic": ["DoubleA1.jpg", "DoubleA2.jpg", "DoubleA3.jpg"],
        "rest": 4,
        "availableFloor": [4, 5]
      },
      E: {
        "name": "雙人房B",
        "chair": "椅子*2",
        "bed": "單人床",
        "desk": "大桌子",
        "sideTable": "小床頭櫃",
        "wardrobe": "衣櫃",
        "size": 6.2,
        "price": 8500,
        "balcony": true,
        "pic": ["DoubleB1.jpg", "DoubleB2.jpg", "DoubleB3.jpg"],
        "rest": 5,
        "availableFloor": [8]
      },
      F: {
        "name": "雙人房C",
        "chair": "椅子*2",
        "bed": "單人床",
        "desk": "大桌子",
        "sideTable": "小床頭櫃",
        "wardrobe": "衣櫃",
        "size": 6.3,
        "price": 8600,
        "balcony": true,
        "pic": ["DoubleC1.jpg", "DoubleC2.jpg", "DoubleC3.jpg"],
        "rest": 0,
        "availableFloor": []
      }
    }

  function renderFeature(n) {
    const roomTypeKeys = Object.keys(roomTypes)[n]
    const roomType = roomTypes[roomTypeKeys];

    $('#room-type-title').text(roomType.name)
    $('#room-type-price').text(roomType.price + " 元 / 月")
    $('#room-type-rest').text(roomType.rest)

    if (roomType.rest == 0) {
      $('#creatBooking').addClass("d-none")
    } else {
      $('#creatBooking').removeClass("d-none")
    }

    if (roomType.availableFloor.length != 0) {
      $('#room-type-available-floor').text(roomType.availableFloor)
    } else {
      $('#room-type-available-floor').text("無")
    }

    if (roomType.balcony == true) {
      $('#room-item-balcony').removeClass('d-none')
    } else {
      $('#room-item-balcony').addClass('d-none')
    }
    $('#room-item-chair').text(roomType.chair)
    $('#room-item-bed').text(roomType.bed)
    $('#room-item-desk').text(roomType.desk)
    $('#room-item-sideTable').text(roomType.sideTable)
    $('#room-item-wardrobe').text(roomType.wardrobe)

    const renderImg = roomType => {
      const $imgBlock = $('#img-slide-block')
      let picNum = 0
      return roomType.pic.forEach(roomTypePic => {
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
  }
  renderFeature(n)

  $('#pre-room-type').click(function () {
    $('#img-slide-block').html("")
    n = (n + 5) % 6
    renderFeature(n)
  })

  $('#next-room-type').click(function () {
    $('#img-slide-block').html("")
    n = (n + 1) % 6
    renderFeature(n)
  })

  $('#creatBooking').click(function () {
    alert("booking!!!!!")

  })
})

