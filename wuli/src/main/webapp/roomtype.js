$(function () {

  const result ={
    'chair' : "椅子*1",
    bed: "單人床",
    desk:"大桌子",
    sideTable:"小床頭櫃",
    wardrobe:"衣櫃"
  }

  $('#room-type').change(function(){
    $('#room-type-main').removeClass('d-none')
    // alert($('#room-type').val())

    $('#room-item-chair').text(result.chair)
    $('#room-item-bed').text(result.bed)
    $('#room-item-desk').text(result.desk)
    $('#room-item-sideTable').text(result.sideTable)
    $('#room-item-wardrobe').text(result.wardrobe)
  })

});
