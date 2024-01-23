<template>
  <div class="main-container">
    <el-container class="CSContainer">
      <el-main>
        <el-carousel ref="carousel" trigger="click" height="672px" >
          <el-carousel-item>
            <span>BMICategory Distribution</span>
            <div id="chartBMICategory" style="width: 858px; height: 672px;margin: 0 140px 0 140px;"></div>
          </el-carousel-item>
          <el-carousel-item>
            <span>Sleep Duration Distribution In Normal Weight People</span>
            <div id="normalSleepDuration" style="width: 858px; height: 672px;margin: 0 140px 0 140px;"></div>
          </el-carousel-item>
          <el-carousel-item>
            <span>Sleep Duration Distribution In Overweight People</span>
            <div id="chartSleepDuration" style="width: 858px; height: 672px;margin: 0 140px 0 140px;"></div>
          </el-carousel-item>
          <el-carousel-item>
            <span>Sleep Duration Distribution In Obese People</span>
            <div id="obeseSleepDuration" style="width: 858px; height: 672px;margin: 0 140px 0 140px;"></div>
          </el-carousel-item>
          <el-carousel-item>
            <span>Stress level in Normal Weight People</span>
            <div id="normalStress" style="width: 858px; height: 672px;margin: 0 140px 0 140px;"></div>
          </el-carousel-item>
          <el-carousel-item>
            <span>Stress level in Overweight People</span>
            <div id="overweightStress" style="width: 858px; height: 672px;margin: 0 140px 0 140px;"></div>
          </el-carousel-item>
          <el-carousel-item>
            <span>Stress level in obese People</span>
            <div id="obeseStress" style="width: 858px; height: 672px;margin: 0 140px 0 140px;"></div>
          </el-carousel-item>
        </el-carousel>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import * as echarts from 'echarts';

export default {
  name: 'mentalHealth',
  data() {
    return {
      chartBMICategoryData: [
        { name: 'Overweight',value: 0.395722 },
        { name: 'Normal' , value: 0.577540 },
        { name: 'Obese' ,value: 0.026738 },
      ],
      chartSleepDurationData: [
        { name: '6.1', value: 10.8108 },
        { name: '6.2', value: 4.0541 },
        { name: '5.8', value: 1.3514 },
        { name: '6.7', value: 3.3784 },
        { name: '6.6', value: 13.5135 },
        { name: '6.5', value: 16.2162 },
        { name: '7.1', value: 1.3514 },
        { name: '6.8', value: 3.3784 },
        { name: '6.3', value: 8.1081 },
        { name: '6.4', value: 4.7297 },
        { name: '7.6', value: 0.6757 },
        { name: '6.9', value: 0.6757 },
        { name: '5.9', value: 0.6757 },
        { name: '6', value: 8.7838 },
        { name: '8.1', value:  8.7838 },
        { name: '8.2', value: 6.0811 },
        { name: '8', value: 7.4324 },
      ],
      obeseSleepDurationData: [
        { name: '5.9', value: 30 },
        { name: '6.3', value: 10 },
        { name: '7.4', value: 20 },
        { name: '7.3', value: 20 },
        { name: '8.1', value: 20 },
      ],
      normalSleepDurationData: [
        { name: '6.2', value: 3.0769 },
        { name: '7.8', value: 13.3333 },
        { name: '6.1', value: 4.6154 },
        { name: '6', value: 9.2308 },
        { name: '7.6', value: 4.6154 },
        { name: '7.7', value: 12.3077 },
        { name: '7.9', value: 3.0769 },
        { name: '7.5', value: 1.0256 },
        { name: '7.2', value: 16.9231 },
        { name: '7.3', value: 5.6410 },
        { name: '7.1', value: 8.2051 },
        { name: '7.4', value: 1.5385 },
        { name: '8.3', value: 2.5641 },
        { name: '8.5', value: 6.6667 },
        { name: '8.4', value: 7.1795 }
      ],
      overweightStress:[
        { name: '6', value: 5.4054 },
        { name: '8', value: 22.9730 },
        { name: '5', value: 2.0270 },
        { name: '7', value: 29.7297 },
        { name: '4', value: 18.9189 },
        { name: '3', value: 20.9459 }
      ],
      obeseStress:[
        { name: '8', value: 30.0000 },
        { name: '7', value: 10.0000 },
        { name: '5', value: 40.0000 },
        { name: '3', value: 20.0000 }
      ],
      normalStress:[
        { name: '8', value: 30.0000 },
        { name: '7', value: 10.0000 },
        { name: '5', value: 40.0000 },
        { name: '3', value: 20.0000 }
      ],
    };
  },
  mounted: function () {
    const obeseStressDom = document.getElementById('obeseStress');
    const obeseStress  = echarts.init(obeseStressDom);
    const obeseStressOption = {
      legend: {
        top: '90%',
      },
      toolbox: {
        show: true,
        feature: {
          mark: { show: true },
          dataView: { show: true, readOnly: false },
          restore: { show: true },
          saveAsImage: { show: true },
        },
      },
      series: [
        {
          name: 'Sleep Duration Distribution',
          type: 'pie',
          radius: [50, 250],
          center: ['50%', '50%'],
          itemStyle: {
            borderRadius: 8,
          },
          data: this.obeseStress,
        },
      ],
    };

    obeseStress .setOption(obeseStressOption);

    const overweightStressDom = document.getElementById('overweightStress');
    const overweightStress  = echarts.init(overweightStressDom);
    const overweightStressOption = {
      legend: {
        top: '90%',
      },
      toolbox: {
        show: true,
        feature: {
          mark: { show: true },
          dataView: { show: true, readOnly: false },
          restore: { show: true },
          saveAsImage: { show: true },
        },
      },
      series: [
        {
          name: 'Sleep Duration Distribution',
          type: 'pie',
          radius: [50, 250],
          center: ['50%', '50%'],
          itemStyle: {
            borderRadius: 8,
          },
          data: this.overweightStress,
        },
      ],
    };

    overweightStress .setOption(overweightStressOption);

    const normalStreeDom = document.getElementById('normalStress');
    const normalStress  = echarts.init(normalStreeDom);
    const normalStressOption = {
      legend: {
        top: '90%',
      },
      toolbox: {
        show: true,
        feature: {
          mark: { show: true },
          dataView: { show: true, readOnly: false },
          restore: { show: true },
          saveAsImage: { show: true },
        },
      },
      series: [
        {
          name: 'Sleep Duration Distribution',
          type: 'pie',
          radius: [50, 250],
          center: ['50%', '50%'],
          itemStyle: {
            borderRadius: 8,
          },
          data: this.normalStress,
        },
      ],
    };

    normalStress .setOption(normalStressOption);

    const normalSleepDurationDom = document.getElementById('normalSleepDuration');
    const normalSleepDuration  = echarts.init(normalSleepDurationDom);
    const normalOption = {
      legend: {
        top: '90%',
      },
      toolbox: {
        show: true,
        feature: {
          mark: { show: true },
          dataView: { show: true, readOnly: false },
          restore: { show: true },
          saveAsImage: { show: true },
        },
      },
      series: [
        {
          name: 'Sleep Duration Distribution',
          type: 'pie',
          radius: [50, 250],
          center: ['50%', '50%'],
          itemStyle: {
            borderRadius: 8,
          },
          data: this.normalSleepDurationData,
        },
      ],
    };

    normalSleepDuration .setOption(normalOption);

    const obeseSleepDurationDom = document.getElementById('obeseSleepDuration');
    const obeseSleepDuration  = echarts.init(obeseSleepDurationDom);
    const obeseOption = {
      legend: {
        top: '90%',
      },
      toolbox: {
        show: true,
        feature: {
          mark: { show: true },
          dataView: { show: true, readOnly: false },
          restore: { show: true },
          saveAsImage: { show: true },
        },
      },
      series: [
        {
          name: 'Sleep Duration Distribution',
          type: 'pie',
          radius: [50, 250],
          center: ['50%', '50%'],
          itemStyle: {
            borderRadius: 8,
          },
          data: this.obeseSleepDurationData,
        },
      ],
    };

    obeseSleepDuration .setOption(obeseOption);

    const chartSleepDurationDom = document.getElementById('chartSleepDuration');
      const myChartSleepDuration  = echarts.init(chartSleepDurationDom);
      const option = {
        legend: {
          top: 'bottom',
        },
        toolbox: {
          show: true,
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            restore: { show: true },
            saveAsImage: { show: true },
          },
        },
        series: [
          {
            name: 'Sleep Duration Distribution',
            type: 'pie',
            radius: [50, 250],
            center: ['50%', '50%'],
            itemStyle: {
              borderRadius: 8,
            },
            data: this.chartSleepDurationData,
          },
        ],
      };

      myChartSleepDuration .setOption(option);


      const chartBMICategoryDom = document.getElementById('chartBMICategory');
      const chartBMICategory = echarts.init(chartBMICategoryDom);
      const optionBMICategory = {
        legend: {
          top: '90%',
        },
        toolbox: {
          show: true,
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            restore: { show: true },
            saveAsImage: { show: true },
          },
        },
        series: [
          {
            name: 'BMICategory Distribution',
            type: 'pie',
            radius: [50, 250],
            center: ['50%', '50%'],
            itemStyle: {
              borderRadius: 8,
            },
            data: this.chartBMICategoryData,
          },
        ],
      };
      chartBMICategory.setOption(optionBMICategory);
    }
  }
</script>

<style>
.main-container {
  display: flex;
  align-items: center; /* 垂直居中 */
  justify-content: center; /* 水平居中 */
  min-height: 120vh;
}

.CSContainer {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 0 140px auto 140px;
  width: 450px;
  padding: 15px 15px 15px 15px;
  background: #eeaef2;
  border: 5px solid #6F2ADD;
}

el-carousel {
  text-align: center; /* 触发器水平居中 */
}
</style>
