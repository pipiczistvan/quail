#!/bin/bash

eval "$(ssh-agent -s)" # Start ssh-agent cache
chmod 600 .travis/id_rsa.enc # Allow read access to the private key
ssh-add .travis/id_rsa.enc # Add the private key to SSH

scp client/android/app/build/outputs/apk/release/app-release-unsigned.apk rsptn.ddns.net:/mnt/hdd1/appholder
