import { defineStore } from 'pinia'
export const useStore = defineStore('storeId1', {
  state: () => {
    return {
      lyon: 'xxxxx',
      count: 0
    }
  },
  actions: {
    increment() {
      console.log(2222)
      this.count++
    }
  }
})
  