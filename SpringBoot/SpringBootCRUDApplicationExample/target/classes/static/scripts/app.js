(function () {
  'use strict';
  angular.module('songApp')
    .controller('AppCtrl', ['$i18next', '$location', '$scope', 'appService', 'commonConstant',
      function (i18next, $location, $scope, appService, commonConstant) {

        var vm = this;
        var cacheMenu = appService.cache;

        function init() {

          vm.changeLang = changeLang;
          vm.isSongMenu = isSongMenu;
          vm.isEnLanguge = isEnLanguge;
          vm.isPlaylistMenu = isPlaylistMenu;
          vm.changeRoute = changeRoute;
          setCurrentMenu($location.path());

        }

        init();

        function setCurrentMenu(path) {
          if ('/songs' === path || '/' === path) {
            cacheMenu.currentMenu.name = commonConstant.MENU_MODE.SONG;
          } else {
            cacheMenu.currentMenu.name = commonConstant.MENU_MODE.PLAYLIST;
          }
        }

        function changeRoute(path) {

          $location.path('/'.concat(path));

          if ('songs' === path || '/' === path) {
            $scope.titleName = 'Songs';
            cacheMenu.currentMenu.name = commonConstant.MENU_MODE.SONG;
          }
          else {
            $scope.titleName = 'Playlists';
            cacheMenu.currentMenu.name = commonConstant.MENU_MODE.PLAYLIST;
          }
        }

        function changeLang(lang) {
          i18next.changeLanguage(lang);
        }

        function isSongMenu() {
          return cacheMenu.currentMenu.name === commonConstant.MENU_MODE.SONG;
        }

        function isEnLanguge() {
          return i18next.options.lng === commonConstant.LANG.EN;
        }

        function isPlaylistMenu() {
          return cacheMenu.currentMenu.name === commonConstant.MENU_MODE.PLAYLIST;
        }
      }])
  ;
})();
