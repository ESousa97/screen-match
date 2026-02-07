#!/bin/sh
# ----------------------------------------------------------------------------
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#   https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
# ----------------------------------------------------------------------------

# ----------------------------------------------------------------------------
# Apache Maven Wrapper startup batch script, version 3.3.2
#
# Required ENV vars:
# ------------------
#   JAVA_HOME - location of a JDK home dir
#
# Optional ENV vars
# -----------------
#   MAVEN_OPTS - parameters passed to the Java VM when running Maven
#     e.g. to debug Maven itself, use
#       set MAVEN_OPTS=-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000
#   MAVEN_SKIP_RC - flag to disable loading of mavenrc files
# ----------------------------------------------------------------------------

if [ -z "$MAVEN_SKIP_RC" ]; then
  if [ -f /usr/local/etc/mavenrc ]; then
    . /usr/local/etc/mavenrc
  fi
  if [ -f /etc/mavenrc ]; then
    . /etc/mavenrc
  fi
  if [ -f "$HOME/.mavenrc" ]; then
    . "$HOME/.mavenrc"
  fi
fi

# OS specific support
cygwin=false
darwin=false
mingw=false
case "$(uname)" in
  CYGWIN*) cygwin=true ;;
  MINGW*) mingw=true ;;
  Darwin*) darwin=true ;;
esac

if [ -z "$JAVA_HOME" ]; then
  if [ -r /etc/gentoo-release ]; then
    JAVA_HOME=$(java-config --jre-home)
  fi
fi

# For Cygwin and MinGW, ensure paths are in Unix format
if $cygwin || $mingw; then
  [ -n "$JAVA_HOME" ] && JAVA_HOME=$(cygpath --unix "$JAVA_HOME")
fi

if [ -z "$JAVA_HOME" ]; then
  javaExecutable="$(which javac)"
  if [ -n "$javaExecutable" ] && ! [ "$(expr "$javaExecutable" : '\([^ ]*\)')" = "no" ]; then
    readLink=$(which readlink)
    if [ ! "$(expr "$readLink" : '\([^ ]*\)')" = "no" ]; then
      if $darwin; then
        javaHome="$(dirname "$javaExecutable")"
        javaHome=$(cd "$javaHome" && pwd -P)/..
      else
        javaExecutable="$(readlink -f "$javaExecutable")"
        javaHome="$(dirname "$javaExecutable")"
        javaHome=$(cd "$javaHome" && pwd -P)/..
      fi
      JAVA_HOME="$javaHome"
      export JAVA_HOME
    fi
  fi
fi

if [ -z "$JAVACMD" ]; then
  if [ -n "$JAVA_HOME" ]; then
    if [ -x "$JAVA_HOME/jre/sh/java" ]; then
      JAVACMD="$JAVA_HOME/jre/sh/java"
    else
      JAVACMD="$JAVA_HOME/bin/java"
    fi
  else
    JAVACMD="$(\\unset -f command 2>/dev/null; \\command -v java)"
  fi
fi

if [ ! -x "$JAVACMD" ]; then
  echo "Error: JAVA_HOME is not defined correctly." >&2
  echo "  We cannot execute $JAVACMD" >&2
  exit 1
fi

if [ -z "$JAVA_HOME" ]; then
  echo "Warning: JAVA_HOME environment variable is not set." >&2
fi

# traverses directory structure from process work directory to filesystem root
# first directory with .mvn subdirectory is considered project base directory
find_maven_basedir() {
  if [ -z "$1" ]; then
    echo "Path not specified to find_maven_basedir"
    return 1
  fi

  basedir="$1"
  wdir="$1"
  while [ "$wdir" != '/' ]; do
    if [ -d "$wdir"/.mvn ]; then
      basedir=$wdir
      break
    fi
    if [ -d "${wdir}" ]; then
      wdir=$(cd "$wdir/.." && pwd)
    fi
  done
  printf '%s' "$(cd "$basedir" && pwd -P)"
}

MAVEN_PROJECTBASEDIR="${MAVEN_BASEDIR:-$(find_maven_basedir "$(pwd)")}"
if [ -z "$MAVEN_PROJECTBASEDIR" ]; then
  echo "Error: Could not determine Maven project base directory." >&2
  exit 1
fi

MAVEN_OPTS="$(concat_lines "$MAVEN_PROJECTBASEDIR/.mvn/jvm.config") $MAVEN_OPTS"

WRAPPER_JAR="$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar"
WRAPPER_PROPERTIES="$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.properties"
WRAPPER_URL="https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.3.2/maven-wrapper-3.3.2.jar"

if [ -r "$WRAPPER_PROPERTIES" ]; then
  WRAPPER_URL=$(grep -E '^wrapperUrl' "$WRAPPER_PROPERTIES" | cut -d'=' -f2-)
fi

if [ ! -e "$WRAPPER_JAR" ]; then
  if command -v wget > /dev/null; then
    if [ "$MVNW_VERBOSE" = true ]; then
      echo "Downloading $WRAPPER_URL"
    fi
    wget $MVNW_VERBOSE --max-redirect=5 -O "$WRAPPER_JAR" "$WRAPPER_URL" || rm -f "$WRAPPER_JAR"
  elif command -v curl > /dev/null; then
    if [ "$MVNW_VERBOSE" = true ]; then
      echo "Downloading $WRAPPER_URL"
    fi
    curl -sL -o "$WRAPPER_JAR" "$WRAPPER_URL" || rm -f "$WRAPPER_JAR"
  else
    echo "Error: Cannot download Maven wrapper. Install wget or curl." >&2
    exit 1
  fi
fi

exec "$JAVACMD" \
  $MAVEN_OPTS \
  $MAVEN_DEBUG_OPTS \
  -classpath "$WRAPPER_JAR" \
  "-Dmaven.multiModuleProjectDirectory=${MAVEN_PROJECTBASEDIR}" \
  org.apache.maven.wrapper.MavenWrapperMain "$@"
