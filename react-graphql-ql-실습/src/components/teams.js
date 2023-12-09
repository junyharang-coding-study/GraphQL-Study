import './components.css';
import {useState} from "react";
import {useQuery, useMutation, gql} from "@apollo/client";

const GET_TEAMS = gql`
    query getTeamByTeamId {
        getTeamByTeamId {
            statusCode,
            message,
            data {
                teamId,
                manager,
                office,
                extensionNumber,
                mascot,
                cleaningDuty,
                project,
                members {
                    peopleId,
                    teamId,
                    lastName,
                    firstName,
                    sex,
                    bloodType,
                    serveYears,
                    role,
                    hometown,
                }
            }
        }
    }
`;

function Teams() {

    const [contentId, setContentId] = useState(0)
    const [inputs, setInputs] = useState({
        manager: "",
        office: "",
        extensionNumber: "",
        mascot: "",
        cleaningDuty: "",
        project: ""
    })

    function AsideItems() {

        const roleIcons = {
            developer: "💻",
            designer: "🎨",
            planner: "📝",
        }

        const {loading, error, data, refetch} = useQuery(GET_TEAMS);

        if (loading) {
            return <p className="loading">로딩 중이에요! 😤</p>
        }

        if (error || data.getTeamByTeamId.statusCode !== 200) {
            return <p className="error">Error가 발생했어요! 🫢</p>
        }

        return (
            <ul>
                {data.getTeamByTeamId.data.map(({teamId, manager, members}) => {
                    return (
                        <li key={teamId}>
                            <span className="teamItemTitle" onClick={() => {
                                setContentId(teamId)
                            }}>
                                Team {teamId} : {manager}'s
                            </span>

                            <ul className="teamMembers">
                                {members.map(({member_teamId, firstName, lastName, role}) => {
                                    return (
                                        <li key={member_teamId}>
                                            {roleIcons[role]} {firstName} {lastName}
                                        </li>
                                    )
                                })}
                            </ul>
                        </li>
                    )
                })}
            </ul>
        )
    }

    function MainContents() {
        return (<div></div>);
    }

    return (
        <div id="teams" className="component">
            <aside>
                {AsideItems()}
            </aside>
            <section className="contents">
                {MainContents()}
            </section>
        </div>
    )
}

export default Teams;