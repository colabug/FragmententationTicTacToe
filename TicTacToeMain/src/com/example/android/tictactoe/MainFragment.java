/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.android.tictactoe.library.GameActivity;
import com.example.android.tictactoe.library.GameView;

public class MainFragment extends Fragment
{
    private final String game = "com.example.android.tictactoe.library.GameActivity";

    /**
     * Called when the activity is first created.
     */
    @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState )
    {
        super.onCreateView( inflater, container, savedInstanceState );
        LinearLayout layout = (LinearLayout) inflater.inflate( R.layout.main,
                                                               container,
                                                               false );
        layout.findViewById( R.id.start_player ).setOnClickListener(
        new OnClickListener()
        {
            public void onClick( View v )
            {
                startGame( true );
            }
        } );

        layout.findViewById( R.id.start_comp ).setOnClickListener(
        new OnClickListener()
        {
            public void onClick( View v )
            {
                startGame( false );
            }
        } );

        return layout;
    }

    private void startGame( boolean startWithHuman )
    {
        Intent i = new Intent( game );
        i.putExtra( GameActivity.EXTRA_START_PLAYER,
                    startWithHuman ? GameView.State.PLAYER1.getValue() : GameView.State.PLAYER2.getValue() );
        startActivity( i );
    }
}
