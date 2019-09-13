#!/bin/sh

TEMP_DIR=/tmp/apk_build
BUILD_DIR=$TRAVIS_BUILD_DIR/client/android/app/build/outputs/apk
TARGET_DIR=pi@rsptn.ddns.net:/mnt/hdd1/appholder

mkdir $TEMP_DIR
find $BUILD_DIR -type f -name '*.apk' -exec cp '{}' $TEMP_DIR ';'
for f in $TEMP_DIR/*.apk; do mv -- "$f" "$TEMP_DIR/$(basename $f .apk)-$(date -r "$f" +"%Y%m%d-%H%M%S").apk"; done
rsync -r --delete-after --quiet $TEMP_DIR $TARGET_DIR
