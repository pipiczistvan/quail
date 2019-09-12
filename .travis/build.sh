#!/bin/sh

cd $TRAVIS_BUILD_DIR/client/android
gradlew clean build

cd $TRAVIS_BUILD_DIR
