#!/bin/sh

openssl aes-256-cbc -K $encrypted_bed876356beb_key -iv $encrypted_bed876356beb_iv -in .travis/deploy_rsa.enc -out /tmp/deploy_rsa -d
eval "$(ssh-agent -s)"
chmod 600 /tmp/deploy_rsa
ssh-add /tmp/deploy_rsa
