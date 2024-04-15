/**
 * This file is part of Aion-Lightning <aion-lightning.org>.
 * <p>
 * Aion-Lightning is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * Aion-Lightning is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details. *
 * You should have received a copy of the GNU General Public License
 * along with Aion-Lightning.
 * If not, see <http://www.gnu.org/licenses/>.
 */


package com.aionemu.chatserver.service;

import com.aionemu.chatserver.network.gameserver.GsAuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ATracer, KID
 */
public class GameServerService {

    private Logger log = LoggerFactory.getLogger(GameServerService.class);
    private static GameServerService instance = new GameServerService();

    public static GameServerService getInstance() {
        return instance;
    }

    public static int GAMESERVER_ID;
    private boolean isOnline = false;

    /**
     * @return
     */
    public GsAuthResponse registerGameServer(int gameServerId,String token) {
        if(!token.equalsIgnoreCase("aion")){
            return GsAuthResponse.NOT_AUTHED;
        }
        GAMESERVER_ID = gameServerId;
        if (isOnline) {
            return GsAuthResponse.ALREADY_REGISTERED;
        }

        isOnline = true;
        return GsAuthResponse.AUTHED;
    }

    public void setOffline() {
        log.info("Gameserver #" + GAMESERVER_ID + " is disconnected");
        isOnline = false;
    }
}
