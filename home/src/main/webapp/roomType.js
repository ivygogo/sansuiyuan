$(function () {
  let n = 0

  const roomTypeA = {
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
  }

  const roomTypeB = {
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

  }
  const roomTypeC = {
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
  }
  const roomTypeD = {
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
  }
  const roomTypeE = {
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
  }
  const roomTypeF = {
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

  const roomTypes = {
    A: roomTypeA,
    B: roomTypeB,
    C: roomTypeC,
    D: roomTypeD,
    E: roomTypeE,
    F: roomTypeF
  }

  function renderFeature(n) {
    const roomTypeKeys = Object.keys(roomTypes)
    const roomType = roomTypes[`${roomTypeKeys[n]}`];

    $('#room-type-title').text(roomType.name)
    $('#room-type-price').text(roomType.price + " 元 / 月")
    $('#room-type-rest').text(roomType.rest)

    if (roomType.availableFloor.length != 0) {
      $('#room-type-available-floor').text(roomType.availableFloor)
    } else {
      $('#room-type-available-floor').text("無")
    }

    $('#room-item-chair').text(roomType.chair)
    $('#room-item-bed').text(roomType.bed)
    $('#room-item-desk').text(roomType.desk)
    $('#room-item-sideTable').text(roomType.sideTable)
    $('#room-item-wardrobe').text(roomType.wardrobe)

    if (roomType.balcony == true) {
      $('#room-item-balcony').removeClass('d-none')
    } else {
      $('#room-item-balcony').addClass('d-none')
    }

    if (roomType.rest == 0) {
      $('#creatBooking').addClass("d-none")
    } else {
      $('#creatBooking').removeClass("d-none")
    }

    const renderImg = roomType => {
      const $imgBlock = $('#img-slide-block')
      let n = 0
      return roomType.pic.forEach(roomTypePic => {
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
  }

  renderFeature(n)

  $('#pre-room-type').click(function () {
    $('#img-slide-block').html("")
    n = (n - 1 + 6) % 6
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

