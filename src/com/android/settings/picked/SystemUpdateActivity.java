/*
 * SPDX-FileCopyrightText: 2026 Miku-Picked UI
 * SPDX-License-Identifier: Apache-2.0
 */

package com.android.settings.picked;

import android.content.Intent;

import com.android.settings.SubSettings;

/**
 * Miku-Picked UI: Settings > System > System update (android.settings.SYSTEM_UPDATE_SETTINGS),
 * the local updater page; also opens a zip handed over by a file manager.
 */
public class SystemUpdateActivity extends SubSettings {

    private static final String PAGE = "com.miku.exsettings.fragments.PickedSystemUpdate";

    @Override
    public Intent getIntent() {
        final Intent intent = new Intent(super.getIntent());
        intent.putExtra(EXTRA_SHOW_FRAGMENT, PAGE);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_TITLE_RESID,
                com.android.settings.R.string.system_update_settings_list_item_title);
        return intent;
    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return PAGE.equals(fragmentName);
    }
}
