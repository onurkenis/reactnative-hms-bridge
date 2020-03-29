# React Native & HMS Sample

This simple repo implements Account Kit, Push Kit and Analytics Kit of HMS ecosystem and aims to be playground for integration of other kits.


## Installing dependencies

```sh
npm install
```
If you are having issues, you can follow [getting started.](https://facebook.github.io/react-native/docs/getting-started.html)


## Running the application

```sh
cd reactnative-hms-bridge
npx react-native run-android --variant=HmsDebug
```
For other variants, check productFlavors in `app/build.gradle`  

## Contributing

Commit messages must comply with [conventional commits](https://www.conventionalcommits.org). Otherwise [commitlint](https://github.com/conventional-changelog/commitlint) will complain. :)

Thanks to [commitizen](https://github.com/commitizen), `npm run commit` command can be used to create commit messages complying with conventional commits.
