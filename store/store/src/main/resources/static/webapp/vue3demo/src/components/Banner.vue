<script setup lang="ts">
import { ref } from 'vue'

// defineProps<{ msg: string }>()

const count = ref(0)
const images = ref([
  'https://fastly.jsdelivr.net/npm/@vant/assets/apple-1.jpeg',
  'https://fastly.jsdelivr.net/npm/@vant/assets/apple-2.jpeg',
])
</script>

<template>
  <div class="containerSwiper">
    <van-swipe :autoplay="3000" lazy-render>
      <van-swipe-item v-for="image in images" :key="image">
        <img :src="image" alt=""/>
      </van-swipe-item>
    </van-swipe>
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
