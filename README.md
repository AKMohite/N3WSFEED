# N3WSFEED
News feed data taken from json file and displayed in app.

### Android security
- always eported=false in manifest
- button: android:filterTouchesWhenObscured="true" to avoid touch when window in obscured or there is other app drawn over your app like fb messenger app
- use encryptedsharedpreferences
- encrypt database(sqlCipher github)
- developer.android.com/topic/security/data
- networking: should implement certificate pinning (can be exploited using tool: charles)
    - only add user certificates allowances in debug-overrides to ensure release builds are secure in network-security-config.xml
- authentication: use revokable tokens
- cryptography: don't use outdated algorithms: SHA-1, MD5, MD4, RC2.
    - use AES-256 for symmetric and RSA-2048/ECC for asymmetric encryption
- only authorised users can perform some actions like deleting/creating/updating your post
- solid code review process with best practices
- static analysis tools
- consider using strict mode to catch errors early
- Code tampering:
    - root detection SDKS: scottyab/rootbeer
    - jetpack security app authentication SDK
- reverse engineering: same as code tampering
- obsuscation of code