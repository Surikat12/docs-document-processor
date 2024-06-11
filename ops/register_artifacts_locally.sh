cd ..\

PROJECT_VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
echo "project version: ${PROJECT_VERSION}"

mvn install:install-file -Dfile="docs-document-processor-client/target/docs-document-processor-client-${PROJECT_VERSION}.jar" -DgroupId="com.surikat.docs" -DartifactId="docs-document-processor-client" -Dversion="${PROJECT_VERSION}" -Dpackaging=jar