/*
 * Copyright (C) 2026 The PenguinOS Project
 * SPDX-FileCopyrightText: 2026 Miku-Picked UI
 * SPDX-License-Identifier: Apache-2.0
 */

package com.android.settings.picked;

import android.content.Intent;
import android.os.Bundle;

import com.android.settings.SubSettings;

import java.util.Set;

/**
 * Opens one of Settings' pages for Penguin Laboratory (vendor/miku/picked/penguin_laboratory),
 * which links to them from its tabs. From PenguinOS' custom.lab.PenguinLabLinkActivity, with
 * this ROM's pages. Only callers holding WRITE_SECURE_SETTINGS can start it, and only the pages
 * listed here can be opened.
 */
public class PenguinLabLinkActivity extends SubSettings {

    private static final String EXTRA_FRAGMENT = "fragment";
    private static final String EXTRA_TITLE = "title";

    private static final Set<String> PAGES = Set.of(
            "com.miku.exsettings.fragments.PickedDepthWallpaper",
            "com.miku.exsettings.fragments.PickedWeather",
            "com.miku.exsettings.fragments.PickedAppAudio",
            "com.miku.exsettings.fragments.PickedClockStyles",
            "com.miku.exsettings.fragments.PickedSleepMode",
            "com.miku.exsettings.fragments.SmartPixels",
            "com.miku.exsettings.fragments.TaskbarSettings",
            "com.miku.exsettings.fragments.ThemeSettings",
            "com.miku.exsettings.fragments.FontsPicker");

    @Override
    public Intent getIntent() {
        final Intent intent = new Intent(super.getIntent());
        intent.removeExtra(EXTRA_SHOW_FRAGMENT);
        final String page = intent.getStringExtra(EXTRA_FRAGMENT);
        if (page != null && PAGES.contains(page)) {
            intent.putExtra(EXTRA_SHOW_FRAGMENT, page);
            final String title = intent.getStringExtra(EXTRA_TITLE);
            if (title != null) {
                intent.putExtra(EXTRA_SHOW_FRAGMENT_TITLE, title);
            }
        }
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        if (getIntent().getStringExtra(EXTRA_SHOW_FRAGMENT) == null) {
            finish();
        }
    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return PAGES.contains(fragmentName);
    }
}
