#!/bin/bash

# Скрипт для обновления версии мода FreeCursor
# Использование: ./update_version.sh 1.1.1

if [ -z "$1" ]; then
    echo "Использование: $0 <версия>"
    echo "Пример: $0 1.1.1"
    exit 1
fi

NEW_VERSION="$1+mc1.21.4"

echo "Обновление версии до $NEW_VERSION..."

# Обновляем gradle.properties
sed -i "s/mod_version=.*/mod_version=$NEW_VERSION/" gradle.properties

echo "Версия обновлена до $NEW_VERSION"
echo "Теперь выполните: ./gradlew build"
