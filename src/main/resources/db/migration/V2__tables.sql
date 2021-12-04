drop table if exists policyapi.policies;
create table policyapi.policies (
    id text primary key,
    title text,
    description text
);

create index description_fulltext_idx on policyapi.policies using GIN (to_tsvector('english',description));

drop table if exists policyapi.policy_sectors;
create table policyapi.policy_sectors (
    policy_id text,
    sector text
);