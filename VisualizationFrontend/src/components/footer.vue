<template>
  <div class='footer-container'>
    <el-footer class='footer' shadow="never">
      <div class="title">
      作者：贺慧杰
      </div>
    </el-footer>
  </div>
</template>

<script>
export default {
  name: 'Footer',
  data() {
    return {};
  },
};
</script>

<style>
.footer {
  background: linear-gradient(to bottom, #eeaef2, #b189f9);
  color: #ffffff;
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
}

.title{
  display: flex;
  align-items: center;
  font-size: 12px;
}

</style>
