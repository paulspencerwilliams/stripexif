#!/bin/sh

docker run -v "$1":/tmp/files exiftool "/tmp/files/$2" -model= -overwrite_original_in_place