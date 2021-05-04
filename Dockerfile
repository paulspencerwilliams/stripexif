FROM        ubuntu:18.04

WORKDIR     /tmp/workdir

RUN     apt-get -yqq update && \
        apt-get --no-install-recommends -yqq install exiftool && \
        rm -rf /var/lib/apt/lists/*

CMD         ["--help"]
ENTRYPOINT  ["exiftool"]
ENV         LD_LIBRARY_PATH=/usr/local/lib
