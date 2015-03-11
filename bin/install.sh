#!/bin/ksh
echo ===============================================================================
echo .
echo      Package sell
echo .
echo ===============================================================================
cd ..
mvn clean
mvn install -Dmaven.test.skip=true
cd -

echo ===============================================================================
echo .
echo      Install sell-biz to local repository
echo .
echo ===============================================================================
cd ..
mvn clean install assembly:assembly -Dmaven.test.skip
cd -
