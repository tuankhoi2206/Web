(function () {
  'use strict';

  window.i18next
    .use(window.i18nextXHRBackend)
    .init({
      // debug: true,
      lng: 'en', // If not given, i18n will detect the browser language.
      fallbackLng: 'vi', // Default is dev
      ns: 'translation',
      backend: {
        loadPath: '../locales/{{lng}}/{{ns}}.json'
      },
      useCookie: false,
      useLocalStorage: false
    }, function () {
      angular.element(function () {
        angular.bootstrap(document, ['songApp']);
      });
    });

  angular
    .module('songApp')
    .config(['$i18nextProvider', '$routeProvider', function ($i18nextProvider, $routeProvider) {
      $routeProvider
        .when('/', {
          templateUrl: 'scripts/song/songs.html',
          controller: 'SongCtrl',
          controllerAs: 'vm'
        })//song
        .when('/songs', {
          templateUrl: 'scripts/song/songs.html',
          controller: 'SongCtrl',
          controllerAs: 'vm'
        })
        .when('/playlists', {
          templateUrl: 'scripts/playlist/playlists.html',
          controller: 'PlaylistCtrl',
          controllerAs: 'vm'
        })
        .otherwise({
          redirectTo: '/'
        });
    }]);

})();
