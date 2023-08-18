import { defineStore } from "pinia"
export const goodList = defineStore('goodList', {
  state: () => {
    return {
      goods: [
        {id: 0, name: 'xxxx', url: 'xxxx'},
        {id: 0, name: 'xxxx', url: 'xxxx'}
      ]
    }
  },
  actions: {
    getGoods() {
      return this.goods;
    }
  }
})
