<template>
  <div class="dashboard-container">
    <router-view></router-view>
  </div>
</template>

<script>
  import {
    mapGetters
  } from 'vuex'
  export default {
    name: 'Dashboard',
    components: {},
    data() {
      return {

        currentRole: 'adminDashboard'
      }
    },
    computed: {
      ...mapGetters([
        'roles'
      ])
    },
    mounted() {

    },
    created() {
      if (!this.roles.includes('admin')) {
        this.currentRole = 'editorDashboard'
      }
    },
    methods: {

    }
  }

</script>
