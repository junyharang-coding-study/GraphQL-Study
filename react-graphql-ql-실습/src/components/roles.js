import './components.css';
import {useState} from "react";
import {useQuery, gql} from "@apollo/client";

const GET_ROLES = gql`
    query GET_ROLES {
        getRoles {
            statusCode,
            pagination {
                data {
                    roleId,
                }
            }
        }
    }
`;

const GET_ROLE = gql`
    query getRoleAndMembersAndEquipmentAndSoftware($roleId: String!) {
        getRoleAndMembersAndEquipmentAndSoftware(roleId: $roleId) {
            statusCode,
            message,
            data {
                roleId,
                requirement,
                members {
                    peopleId,
                    lastName,
                    serveYears,
                },
                equipments {
                    equipmentId,
                },
                softwares {
                    softwareId
                },
            },
        }
    }
`;

function Roles() {

    const [contentId, setContentId] = useState("");

    function AsideItems() {
        const roleIcons = {
            developer: "💻",
            designer: "🎨",
            planner: "📝",
        }

        const {loading, error, data} = useQuery(GET_ROLES);

        if (loading) {
            return <p className="loading">로딩 중이에요! 😤</p>
        }

        if (error || data.getRoles.statusCode !== 200) {
            return <p className="error">Error가 발생했어요! 🫢</p>
        }

        return (
            <ul>
                {data.getRoles.pagination.data.map(({roleId}) => {
                    return (
                        <li key={roleId} className={"roleItem" + (contentId === "id" ? "on" : "")}
                            onClick={() => {
                                setContentId(roleId)
                            }}>
                            <span>{contentId === roleId ? "⬜️" : "⬛️"}</span>
                            {roleIcons[roleId]} {roleId}
                        </li>
                    )
                })}
            </ul>
        );
    }

    function MainContents() {

        const { loading, error, data } = useQuery(GET_ROLE, {
            variables: {roleId: contentId}
        })

        if (loading) {
            return <p className="loading">로딩 중이에요! 😤</p>
        }

        if (error) {
            return <p className="error">Error가 발생했어요! 🫢</p>
        }

        if (contentId === "") {
            return (
                <div className="roleWrapper">역할을 선택해 주세요! 😤</div>
            )
        }

        return (
            <div className="roleWrapper">
                <h2>{data.getRoleAndMembersAndEquipmentAndSoftware.data.roleId}</h2>

                <div className="requirement">
                    <span>{data.getRoleAndMembersAndEquipmentAndSoftware.data.requirement}</span>
                    required
                </div>

                <h3>멤버 목록</h3>
                <ul>
                    {data.getRoleAndMembersAndEquipmentAndSoftware.data.members.map((member) => {
                        return (<li>{member.lastName}</li>)
                    })}
                </ul>

                <h3>장비 목록</h3>
                <ul>
                    {data.getRoleAndMembersAndEquipmentAndSoftware.data.equipments.map((equipment) => {
                        return (<li>{equipment.equipmentId}</li>)
                    })}
                </ul>

                <h3>Software 목록</h3>
                <ul>
                    {data.getRoleAndMembersAndEquipmentAndSoftware.data.softwares.map((software) => {
                        return (<li>{software.softwareId}</li>)
                    })}
                </ul>
            </div>
        )
    }

    return (
        <div id="roles" className="component">
            <aside>
                {AsideItems()}
            </aside>
            <section className="contents">
                {MainContents()}
            </section>
        </div>
    )
}

export default Roles;