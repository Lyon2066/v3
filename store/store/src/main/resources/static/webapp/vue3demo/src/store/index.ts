import { createStore} from "vuex"
const store = createStore({
  state: {
    count: 0
  },
  actions: {
    addCount({state,commit},data){
      setTimeout(() => {
        commit('addCount_M',data)
      }, 300);
    }
  },
  mutations: {
    addCount_M(state,data){
      state.count += data
    }
  },
  getters:{
    getCount(state) {
      return state.count + '次数'
    }
  }
})
export default store