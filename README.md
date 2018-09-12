# kurdia-Utils

[![](https://jitpack.io/v/HosseinKurd/kurdia-Utils.svg)](https://jitpack.io/#HosseinKurd/kurdia-Utils)

[![NPM version](https://img.shields.io/badge/version-1.5.20-brightgreen.svg)](https://github.com/HosseinKurd/kurdia-Utils)
![NPM version](https://img.shields.io/badge/min%20sdk-19-brightgreen.svg)

# Requirements
- IDE : android studio
- Minimum SDK : 19

It Provides usable Methods And Classes to you 

# Installation

**Add these permissions to `AndroidManifest.xml`**

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

**Add Dependency**

Step 1. Add the JitPack repository to your build file

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.HosseinKurd:kurdia-Utils:1.6.2'
	}