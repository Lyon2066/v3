<template>
  <div class="home">
    Lyon: {{Lyon}}
    <h1>{{count}} ddd </h1>
    <h2>{{getCount()}}</h2>
    <button @click="addNum">操作actionsFn</button>
    <button @click="addNum_M">直接操作mutationsFn</button>
    <button @click="getVal">直接操作gettersFn</button>
  </div>
</template>

<script lang="ts">

import { defineComponent } from 'vue';
import {mapActions,mapMutations,mapState,mapGetters} from 'vuex'

export default defineComponent({
  name: 'Home',
  components: {
  },
  computed:{
    ...mapState(['count', 'Lyon']),
  },
  methods: {
    ...mapActions(['addCount']),
    ...mapMutations(['addCount_M']),
    ...mapGetters(['getCount']),
    addNum() {
      // this.$store.dispatch("addCount",5)// 
      this.addCount(5)
    },
    addNum_M() {
      // this.$store.commit("addCount_M",10)
      this.addCount_M(10)
    },
    getVal() {
      const v = this.getCount()
      console.log(v)
    }
  }
});
</script>
<style scoped>
  .home button{
    width:80px;
    height:  40px;
  }
</style>