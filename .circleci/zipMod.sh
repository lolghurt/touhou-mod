#!/bin/sh
https://https://github.com/lolghurt/touhou-mod/blob/master/.circleci/zipMod.sh
# CHANGE ME
modFolderName="Touhou-Mod"

version=$(git describe --tags)
zipName=$modFolderName-$version.zip
git archive master -o $zipName --prefix $modFolderName-$version/
mkdir -p ./artifacts
mv ./$zipName ./artifacts/
