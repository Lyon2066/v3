<template>
  <div class="home">
    <Banner></Banner>
    <CardList></CardList>
    <div>{{ store.lyon }}</div>
    <div>{{ store.count }}</div>
    <button @click="store.increment"></button>
    <div v-for="(good,idx) in goods.goods" :key="idx">{{ good.name }}</div>
  </div>
</template>

<script setup lang="ts">

import { defineComponent, onMounted, ref, toRef, toRefs } from 'vue';
// import {mapActions,mapMutations,mapState,mapGetters} from 'vuex'
import Banner from '@/components/Banner.vue'
import CardList from '@/components/CardList.vue';
import { useStore } from '../pinia';
import { goodList } from '../pinia/goodList';
// import { storeToRefs } from 'pinia'; // 解构store
const store = useStore()
const goods = goodList();
onMounted(()=> {
  console.log(goods.$id)
  console.log(goods.goods)
})
// const {lyon, count} = storeToRefs(store) //解构出来state 数据
// console.log(count)
</script>
<style scoped>
  .home button{
    width:80px;
    height:  40px;
  }
</style>