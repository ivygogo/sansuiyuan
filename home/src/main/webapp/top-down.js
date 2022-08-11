$(function () {
  $.ajax('/home/api/v1/stores')
  .done(stores => {
    const $stores = $('#stores')
    return stores.result.forEach(store => {
      const $store = $(document.createElement('li'))
      const $storeImage = $(document.createElement('img'))
      .attr('src', store.image)
      .attr('alt', store.name)
      .text(store.name)
      const $storeName = $(document.createElement('h3'))
      .text(store.name)
      $store.append($storeImage).append($storeName).appendTo($stores)
    })
  })
})
