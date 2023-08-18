<script setup lang="ts">
import { ref } from 'vue'
const cardList = ref([{
  cid: 1,
  name: '限时秒杀',
},{
  cid: 2,
  name: '断码清仓',
}])
</script>

<template>
  <div class="card-list">
    <div v-for="cList in cardList" :key="cList.cid">
      {{ cList.name }}
    </div>
  </div>
</template>

<style scoped lang="scss">
$mianColor: red;
.containerSwiper {
  width: 94%;
  height: 200px;
  margin: 10px auto 0;
  // background-color: $mianColor;
  box-shadow: 0px 0px 6px rgba(86, 86, 90, .3);
  img {
    width: 100%;
    height: 200px;
  }
}
</style>
