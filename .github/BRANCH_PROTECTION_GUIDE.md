# Guide: Konfigurera Branch Protection Rules för Code Review

Detta dokument beskriver hur man konfigurerar GitHub branch protection rules så att minst en person måste göra en code review innan en pull request kan mergas.

## Steg för att aktivera Branch Protection Rules

### 1. Gå till Repository Settings
1. Öppna repository på GitHub
2. Klicka på **Settings** (längst upp till höger)
3. I vänster sidopanel, klicka på **Branches** under "Code and automation"

### 2. Lägg till Branch Protection Rule
1. Under "Branch protection rules", klicka på **Add rule** eller **Add classic branch protection rule**
2. I fältet "Branch name pattern", skriv `main` eller `master` (beroende på din huvudbranch)
   - Du kan också använda `*` för att skydda alla branches

### 3. Konfigurera Code Review Requirements
Markera följande alternativ för att kräva code reviews:

#### ✅ Require a pull request before merging
- [x] **Require a pull request before merging**
  - Detta säkerställer att all kod går genom en pull request
  
  Under detta alternativ, konfigurera:
  - [x] **Require approvals** - Ställ in antal godkännanden till **1** eller fler
    - **Antal godkännanden**: Välj minst **1** reviewer som måste godkänna
  - [ ] **Dismiss stale pull request approvals when new commits are pushed** (rekommenderas)
    - Detta innebär att om nya commits pushas efter ett godkännande, måste koden granskas igen
  - [ ] **Require review from Code Owners** (rekommenderas om du använder CODEOWNERS)
    - Detta kräver att någon från CODEOWNERS filen godkänner ändringarna

#### ✅ Require status checks to pass before merging (valfritt men rekommenderas)
- [ ] **Require status checks to pass before merging**
  - Aktivera detta om du har CI/CD pipelines som ska köras
  - [ ] **Require branches to be up to date before merging**

#### ✅ Require conversation resolution before merging (rekommenderas)
- [x] **Require conversation resolution before merging**
  - Detta säkerställer att alla kommentarer i code review är lösta

### 4. Ytterligare rekommenderade inställningar

#### Do not allow bypassing the above settings
- [x] **Do not allow bypassing the above settings**
  - Detta förhindrar administratörer från att kringgå reglerna (rekommenderas starkt)

#### Restrict who can push to matching branches (valfritt)
- [ ] **Restrict who can push to matching branches**
  - Begränsa vilka som kan pusha direkt till protected branches

#### Allow force pushes (rekommenderas INTE)
- [ ] **Allow force pushes**
  - Lämna detta omarkerat för att förhindra force pushes

#### Allow deletions (rekommenderas INTE)
- [ ] **Allow deletions**
  - Lämna detta omarkerat för att förhindra borttagning av protected branches

### 5. Spara reglerna
1. Scrolla ner och klicka på **Create** eller **Save changes**

## Sammanfattning - Checklista för Code Review Rules

När du konfigurerar branch protection rules, markera följande:

### Grundläggande (Minsta krav):
- [x] **Require a pull request before merging**
- [x] **Require approvals** → Sätt till minst **1**
- [x] **Require conversation resolution before merging**
- [x] **Do not allow bypassing the above settings**

### Rekommenderat (För bättre säkerhet):
- [x] **Dismiss stale pull request approvals when new commits are pushed**
- [x] **Require review from Code Owners** (om CODEOWNERS används)
- [x] **Require status checks to pass before merging** (om CI/CD finns)
- [x] **Require branches to be up to date before merging**

### Säkerhet (Skydda branches):
- [ ] **Restrict who can push to matching branches** (om behövs)
- [ ] **Allow force pushes** (lämna OMARKERAD)
- [ ] **Allow deletions** (lämna OMARKERAD)

## Vad händer efter konfigurationen?

1. **Nya pull requests**: När någon skapar en pull request till en skyddad branch kommer:
   - GitHub automatiskt begära review från CODEOWNERS (om konfigurerat)
   - Pull requesten kan inte mergas förrän minst 1 person har godkänt

2. **Code Review Process**:
   - Reviewer granskar koden och lämnar kommentarer
   - Reviewer godkänner (approve) eller begär ändringar (request changes)
   - Om ändringar begärs, måste författaren fixa och pusha nya commits
   - När allt är godkänt kan pull requesten mergas

3. **CODEOWNERS**: 
   - Med CODEOWNERS filen som skapats kommer GitHub automatiskt att begära reviews från rätt personer baserat på vilka filer som ändrats

## Felsökning

**Problem**: Jag kan inte merge trots att jag har approval
- Kontrollera att alla conversations är resolved
- Kontrollera att alla required status checks har passerat
- Kontrollera att branchen är up-to-date med base branchen

**Problem**: Jag kan inte se Settings i repository
- Du behöver admin-rättigheter till repository för att konfigurera branch protection rules
- Kontakta repository ägaren för att få rättigheter

## Relaterade filer
- `.github/CODEOWNERS` - Definierar vem som äger olika delar av kodebasen
- `.github/PULL_REQUEST_TEMPLATE.md` - Mall för pull requests med checklista

## Ytterligare resurser
- [GitHub Docs: About branch protection rules](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/defining-the-mergeability-of-pull-requests/about-protected-branches)
- [GitHub Docs: About code owners](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-code-owners)
