/* eslint-disable */
<template>
  <el-card v-show="isSearchCardShow" style="margin-bottom: 20px">
    <!--查询条件区域-->
    <div class="filter-container">
      <!--具体的查询条件，使用placeholder来显示标题-->
      <el-input v-model="listQuery.query.codeName" placeholder="模块名" style="width: 305px;"
        @keyup.enter.native="handleFilter" />
      <el-input v-model="listQuery.query.serviceName" placeholder="服务名" style="width: 305px;"
        @keyup.enter.native="handleFilter" />
      <el-select v-model="listQuery.query.datasourceId" placeholder="数据源" style="width: 305px;" class="filter-item"
        @keyup.enter.native="handleFilter">
        <el-option v-for="item in dicData" :key="item.id" :label="item.name" :value="item.id" />
      </el-select>
      <el-button v-waves type="primary" style="margin:0 0 0 20px;" round icon="el-icon-search" @click="handleFilter">{{
        $t('table.search') }}</el-button>
      <el-button v-waves style="margin: 10px;" icon="el-icon-delete" round @click="resetListQuery()">{{
        $t('table.reset')
        }}</el-button>
    </div>
  </el-card>
</template>
<script>
  // 调用相应的api文件中的方法，来操纵数据
  import listQuery from '@/entitys/code'
  // 按钮的水波纹
  import waves from '@/directive/waves' // Waves directive
  // model 文件
  export default {
    // TODO:本页面的名称
    name: 'codes-searchCard',
    directives: {
      waves
    },
    props: {
      isSearchCardShow: {
        type: Boolean,
        default: false
      },
      dicData: {
        type: Array,
        default: function () {
          return []
        }
      }
    },
    data() {
      // 初始化整个页面用到的数据
      return {
        rangeDate: undefined,
        listQuery: listQuery()
      }
    },
    // 初始化所有的数据
    created() {},
    methods: {
      resetListQuery() {
        this.listQuery = listQuery()
        this.$parent.$refs.listTable.listQuery = this.listQuery // 修改listTable里的listQuery
      },
      handleFilter() {
        this.listQuery.current = 1
        this.$parent.$refs.listTable.getList(this.listQuery)
      }
    }
  }

</script>
