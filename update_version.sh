#!/bin/bash

# Скрипт для обновления версии мода FreeCursor
# Использование: ./update_version.sh <новая_версия>
# Пример: ./update_version.sh 1.2.11

if [ $# -eq 0 ]; then
    echo "Использование: $0 <новая_версия>"
    echo "Пример: $0 1.2.11"
    exit 1
fi

NEW_VERSION="$1+mc1.21.4+"

echo "Обновление версии мода до $NEW_VERSION..."

# Обновляем gradle.properties
sed -i "s/^mod_version=.*/mod_version=$NEW_VERSION/" gradle.properties

# Обновляем CHANGELOG.md
CURRENT_DATE=$(date +%Y-%m-%d)
sed -i "s/## \[Unreleased\]/## [Unreleased]\n\n## [$NEW_VERSION] - $CURRENT_DATE\n\n### Added\n- Version update to $NEW_VERSION\n\n### Changed\n- Updated mod version\n\n### Technical\n- Build system updates/" CHANGELOG.md

# Обновляем README текущую версию, если строка присутствует
if grep -q "^\*\*Current version\*\*" README.md; then
  sed -i "s/\*\*Current version\*\*: \`.*\`/**Current version**: \`$NEW_VERSION\`/" README.md
fi

echo "Версия успешно обновлена до $NEW_VERSION"
echo "Соберите проект: ./gradlew build"
