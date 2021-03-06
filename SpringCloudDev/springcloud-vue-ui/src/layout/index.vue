<template>
  <div :class="classObj" class="app-wrapper">
    <div v-if="device==='mobile'&&sidebar.opened" class="drawer-bg" @click="handleClickOutside" />
    <sidebar class="sidebar-container" />
    <div :class="{hasTagsView:needTagsView}" class="main-container">
      <div :class="{'fixed-header':fixedHeader}">
        <navbar />
        <tags-view v-if="needTagsView" />
      </div>
      <app-main />
      <right-panel v-if="showSettings">
        <settings />
      </right-panel>
    </div>
  </div>
</template>

<script>
  import RightPanel from '@/components/RightPanel'
  import {
    AppMain,
    Navbar,
    Settings,
    Sidebar,
    TagsView
  } from './components'
  import ResizeMixin from './mixin/ResizeHandler'
  import {
    mapState
  } from 'vuex'
  import {
    calcDate
  } from '@/utils/date.js'
  import {
    getStore
  } from '@/utils/store.js'
  import {
    validatenull
  } from '@/utils/validate.js'
  export default {
    name: 'Layout',
    components: {
      AppMain,
      Navbar,
      RightPanel,
      Settings,
      Sidebar,
      TagsView
    },
    mixins: [ResizeMixin],
    data() {
      return {
        // 刷新token锁
        refreshLock: false,
        // 刷新token的时间
        refreshTime: ''
      }
    },
    computed: {
      ...mapState({
        sidebar: state => state.app.sidebar,
        device: state => state.app.device,
        showSettings: state => state.settings.showSettings,
        needTagsView: state => state.settings.tagsView,
        fixedHeader: state => state.settings.fixedHeader,
        website: state => state.settings.website
      }),
      classObj() {
        return {
          hideSidebar: !this.sidebar.opened,
          openSidebar: this.sidebar.opened,
          withoutAnimation: this.sidebar.withoutAnimation,
          mobile: this.device === 'mobile'
        }
      }
    },
    created() {
      // 实时检测刷新token
      this.refreshToken()
    },
    methods: {
      handleClickOutside() {
        this.$store.dispatch('app/closeSideBar', {
          withoutAnimation: false
        })
      },
      // 10分钟检测一次token
      refreshToken() {
        this.refreshTime = setInterval(() => {
          const tokenTime = getStore({
            name: 'tokenTime',
            debug: false
          })
          const date = calcDate(tokenTime, new Date().getTime())
          if (validatenull(date)) return
          if ((date.seconds >= this.website.tokenTime) && !this.refreshLock) {
            this.refreshLock = true
            this.$store
              .dispatch('user/refeshToken')
              .then(() => {
                this.refreshLock = false
              })
              .catch(() => {
                this.refreshLock = false
              })
          }
        }, 600000)
      }
    }
  }

</script>

<style lang="scss" scoped>
  @import "~@/styles/mixin.scss";
  @import "~@/styles/variables.scss";

  .app-wrapper {
    @include clearfix;
    position: relative;
    height: 100%;
    width: 100%;

    &.mobile.openSidebar {
      position: fixed;
      top: 0;
    }
  }

  .drawer-bg {
    background: #000;
    opacity: 0.3;
    width: 100%;
    top: 0;
    height: 100%;
    position: absolute;
    z-index: 999;
  }

  .fixed-header {
    position: fixed;
    top: 0;
    right: 0;
    z-index: 9;
    width: calc(100% - #{$sideBarWidth});
    transition: width 0.28s;
  }

  .hideSidebar .fixed-header {
    width: calc(100% - 54px)
  }

  .mobile .fixed-header {
    width: 100%;
  }

</style>
