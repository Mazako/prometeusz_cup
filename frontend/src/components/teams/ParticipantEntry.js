import {getImageIcon, getLaneIcon, getTierIcon} from "../../endpoints/endpoints";

export function ParticipantEntry({name, iconId, captain, soloqTier, soloqRank, flexTier, flexRank, role}) {
    return (
        <li>
            <img src={getImageIcon(iconId)} width={100} height={100} />
            <p>{name}</p>
            <div>
                <img src={getTierIcon(soloqTier)} width={100} height={100} alt={soloqTier}/>
                <p>{soloqRank}</p>
            </div>
            <div>
                <img src={getTierIcon(flexTier)} width={100} height={100} alt={flexTier}/>
                <p>{flexRank}</p>
            </div>
            <img src={getLaneIcon(role)} width={50} height={50}/>
        </li>
    )
}