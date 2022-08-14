$(function () {

  const roomType0 = {}

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

  //JSon內又是個JSon
  const roomTypes = {
    0: roomType0,
    A: roomTypeA,
    B: roomTypeB,
    C: roomTypeC,
    D: roomTypeD,
    E: roomTypeE,
    F: roomTypeF
  }

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
    $('#room-position-value').remove()
    $(document.createElement("div")).text(
      '位置 : ' + $('#room-position').val()).attr('id',
      'room-floor-value').appendTo($('#tenant-information'))
  })

  $('#room-type').change(function () {
    $('#room-type-value').remove()
    $(document.createElement("div")).text(
      '房型代號 : ' + $('#room-type').val() + '  房型名稱 : ' + $(
        '#room-type option:selected').text()).attr('id',
      'room-type-value').appendTo($('#tenant-information'))

    $('#room-type-main').removeClass('d-none')

    const roomType = roomTypes[$('#room-type').val()];

    if (!roomType) {
      console.error('no room type');
      return;
    } else if (roomType == roomType0) {
      $('#room-type-main').addClass('d-none')
      $('#room-price').text("------")
      $('#room-size').text("------")
      $('#room-status').text("------")
    }

    //清除圖片
    $('#img-slide-block').html("")

    //根據房型新增圖片上去
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

