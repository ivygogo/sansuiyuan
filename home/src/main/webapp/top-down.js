$(function () {
  const stores = {
    "result": [
      {
        "name": "派克雞排",
        "image": "https://via.placeholder.com/150"
      },
      {
        "name": "Starbugs",
        "image": "https://picsum.photos/id/1060/150"
      },
      {
        "name": "芭比Q蛋糕",
        "image": "https://picsum.photos/150"
      }
    ]
  }

  const renderStores = stores => {
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
  }

  renderStores(stores)
})
