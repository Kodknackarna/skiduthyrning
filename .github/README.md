# GitHub Configuration för skiduthyrning

Denna mapp innehåller GitHub-konfigurationsfiler och dokumentation för projektet.

## Filer

### CODEOWNERS
Definierar vem som automatiskt tilldelas som reviewers för olika delar av kodebasen.

### PULL_REQUEST_TEMPLATE.md
Mall som automatiskt används när någon skapar en ny pull request. Innehåller en checklista för att säkerställa kvalitet.

### BRANCH_PROTECTION_GUIDE.md
**📋 Steg-för-steg guide** för att konfigurera branch protection rules i GitHub så att minst en person måste göra code review.

## Snabbstart

För att sätta upp code review rules:
1. Läs [BRANCH_PROTECTION_GUIDE.md](BRANCH_PROTECTION_GUIDE.md)
2. Följ checklistan i guiden
3. Konfigurera branch protection rules i GitHub Settings → Branches

## Viktigt att markera i GitHub Settings

När du sätter upp branch protection rules, markera minst:
- ✅ Require a pull request before merging
- ✅ Require approvals (minst 1)
- ✅ Require conversation resolution before merging
- ✅ Do not allow bypassing the above settings

Se [BRANCH_PROTECTION_GUIDE.md](BRANCH_PROTECTION_GUIDE.md) för fullständig information.
