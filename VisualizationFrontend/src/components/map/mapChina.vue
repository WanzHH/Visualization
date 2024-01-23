<template>
  <div class='main-container'>
    <el-container>
      <el-main>
        <head>
          <meta charset="utf-8">
        </head>
        <body>
        <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
        <div id="main" style="width: 1458px;height:972px;"></div>
        </body>

      </el-main>
    </el-container>
  </div>
</template>


<script>
import * as echarts from 'echarts';
import '@/js/echarts.min.js';
import '@/js/china.js';

export default {
  name: 'MapChart',
  data() {
    return {
      name_title: '中国因非传染病过早死亡概率',
      mapName: 'china',
      data: [
        { name: '湖北', value: 18 },
        { name: '浙江', value: 24 },
        { name: '广东', value: 15 },
        { name: '湖南', value: 17 },
        { name: '河南', value: 17 },
        { name: '江西', value: 24 },
        { name: '安徽', value: 23 },
        { name: '重庆', value: 20 },
        { name: '山东', value: 17 },
        { name: '四川', value: 17 },
        { name: '江苏', value: 16 },
        { name: '上海', value: 19 },
        { name: '北京', value: 17 },
        { name: '福建', value: 10 },
        { name: '广西', value: 10 },
        { name: '河北', value: 7 },
        { name: '云南', value: 19 },
        { name: '陕西', value: 12 },
        { name: '黑龙江', value: 18 },
        { name: '海南', value: 15 },
        { name: '辽宁', value: 12 },
        { name: '山西', value: 29 },
        { name: '天津', value: 7 },
        { name: '甘肃', value: 22 },
        { name: '内蒙古', value: 18 },
        { name: '宁夏', value: 37 },
        { name: '吉林', value: 10 },
        { name: '新疆', value: 39 },
        { name: '贵州', value: 12 },
        { name: '香港', value: 1 },
        { name: '台湾', value: 4 },
        { name: '青海', value: 38 },
        { name: '澳门', value: 3 },
        { name: '西藏', value: 24 },
        // ... 其他省份数据
      ],
    };
  },
  mounted() {
    this.$nextTick(() => {
      const myChart = echarts.init(document.getElementById('main'));
      const option = {
        title: {
          text: this.name_title,
          x: 'center',
          textStyle: {
            fontSize: 24,
          },
        },
        tooltip: {
          trigger: 'item',
          formatter: (params) => {
            let toolTiphtml = '';
            if (isNaN(params.value)) {
              toolTiphtml = params.name + '确诊: 0例';
            } else {
              toolTiphtml = params.name + '概率: ' + params.value + '%';
            }
            return toolTiphtml;
          },
        },
        toolbox: {
          feature: {
            saveAsImage: {},
          },
        },
        visualMap: {
          show: true,
          left: 'left',
          top: 'bottom',
          seriesIndex: [0],
          type: 'piecewise',
          pieces: [
            { min: 25.1, color: 'rgb(254,57,101)' },
            { min: 20.1, max: 25 , color: 'rgb(252,157,154)' },
            { min: 15.1, max: 20, color: 'rgb(249,205,173)' },
            { min: 10.1, max: 15, color: 'rgb(200,200,169)' },
            { min: 0.1, max: 10, color: 'rgb(131,175,155)' },
          ],
          textStyle: {
            color: '#000000',
          },
        },
        geo: {
          show: true,
          map: this.mapName,
          left: 'center', // 调整地图在页面中的水平位置
          top: 'center',  // 调整地图在页面中的垂直位置
          label: {
            normal: {
              show: true,
              fontSize: 12,
            },
            emphasis: {
              show: false,
            },
          },
          roam: false,
          itemStyle: {
            normal: {
              areaColor: '#FFFFFF',
              borderColor: '#666666',
            },
            emphasis: {
              areaColor: '#0099CC',
            },
          },
        },
        series: [
          {
            type: 'map',
            map: this.mapName,
            geoIndex: 0,
            animation: false,
            data: this.data,
          },
        ],
      };
      myChart.setOption(option);
    });
  },
};
</script>

<style>
/* 更改 .layout 为 .main-container */
.main-container {
  display: flex;
//flex-direction: column;
  min-height: 100vh;
  background-color: #eeaef2;
  flex: 1; /* 使 .main-container 占据剩余的所有空间 */
}
.map-container {
  display: flex; /* 使用 Flex 布局 */
  justify-content: center; /* 在水平方向上居中 */
  align-items: center; /* 在垂直方向上居中 */
  min-height: 100vh; /* 设置最小高度为视口高度 */
}
</style>
