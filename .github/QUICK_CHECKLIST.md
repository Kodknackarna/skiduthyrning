# Snabb Checklista: Code Review Setup

## ✅ Vad ska markeras i GitHub Settings → Branches?

När du sätter upp branch protection rules för `main` branchen, använd denna checklista:

### Steg 1: Hitta rätt plats
1. Gå till repository på GitHub
2. Klicka på **Settings** (högst upp)
3. Klicka på **Branches** (vänster sidopanel)
4. Klicka på **Add rule** eller **Add classic branch protection rule**
5. Skriv `main` i "Branch name pattern"

### Steg 2: Markera dessa alternativ (MINSTA KRAV)

#### ✅ Require a pull request before merging
- [x] **Require a pull request before merging**
  - [x] **Require approvals**: Ställ in till **1** (eller fler)

#### ✅ Require conversation resolution before merging  
- [x] **Require conversation resolution before merging**

#### ✅ Do not allow bypassing the above settings
- [x] **Do not allow bypassing the above settings**

### Steg 3: Rekommenderade extra alternativ

#### 🔒 För bättre säkerhet:
- [x] **Dismiss stale pull request approvals when new commits are pushed**
- [x] **Require review from Code Owners**

#### 🚫 Lämna OMARKERADE (för att skydda branchen):
- [ ] **Allow force pushes** (lämna omarkerad!)
- [ ] **Allow deletions** (lämna omarkerad!)

### Steg 4: Spara
- Scrolla ner och klicka på **Create** eller **Save changes**

---

## 📋 Sammanfattning

| Inställning | Markera? | Viktighet |
|------------|----------|-----------|
| Require a pull request before merging | ✅ JA | **OBLIGATORISK** |
| Require approvals (minst 1) | ✅ JA | **OBLIGATORISK** |
| Require conversation resolution | ✅ JA | **OBLIGATORISK** |
| Do not allow bypassing | ✅ JA | **OBLIGATORISCH** |
| Dismiss stale approvals | ✅ JA | Rekommenderad |
| Require review from Code Owners | ✅ JA | Rekommenderad |
| Allow force pushes | ❌ NEJ | **VIKTIGT** |
| Allow deletions | ❌ NEJ | **VIKTIGT** |

---

## 🎯 Resultat

Efter att du har sparat dessa inställningar:
- ✅ Pull requests kan inte mergas utan minst 1 godkännande
- ✅ Alla kommentarer måste vara lösta innan merge
- ✅ GitHub begär automatiskt reviews från @Kodknackarna (via CODEOWNERS)
- ✅ Ingen kan kringgå dessa regler (även inte admins)

---

## 📚 Mer information
Se [BRANCH_PROTECTION_GUIDE.md](BRANCH_PROTECTION_GUIDE.md) för fullständig dokumentation.
